import java.util.*;
import java.io.*;

public class _boj_1005 {
	static boolean adj[][];
	static int N,M;
	static int indegree[];
	static int result[];
	static int time[];
	
	
	static void topocologiSort(boolean adj[][], int time[], int indegree[]) {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
			if(indegree[i] == 0) {
				q.add(i);
				result[i] = time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int y = 1 ; y <= N ; y++) {
				if(adj[p][y]) {
					result[y] = Math.max(result[y], result[p] + time[y]);
					if(--indegree[y] == 0) q.add(y);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adj = new boolean[N+1][N+1];
			result = new int[N+1];
			time = new int[N+1];
			indegree = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i<= N ; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
					
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adj[u][v] = true;
				indegree[v]++;
			}
			int K = Integer.parseInt(br.readLine());
			topocologiSort(adj,time,indegree);
			bw.write(result[K]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
