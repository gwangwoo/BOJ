import java.util.*;
import java.io.*;

public class _boj_10159 {
	static ArrayList<Integer> arl[];
	static ArrayList<Integer> brl[];
	static int N,M;
	static int arr[];
	static int brr[];
	
	static int bfs(ArrayList<Integer> list[] , int start) {
		boolean visited[] = new boolean[N+1];
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int y : list[p]) {
				if(visited[y]) continue;
				visited[y] = true;
				cnt++;
				q.add(y);
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arl = new ArrayList[N+1];
		brl = new ArrayList[N+1];
		arr = new int[N+1];
		brr = new int[N+1];
		for(int i = 1  ; i<= N ; i++) {
			arl[i] = new ArrayList<>();
			brl[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arl[a].add(b);
			brl[b].add(a);
		}
		
		for(int i = 1 ; i <= N ; i++) {
			int cnt = bfs(arl,i);
			arr[i] = cnt;
			cnt = bfs(brl,i);
			brr[i] = cnt;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1 ; i <= N ; i++) {
			bw.write(N-1-arr[i]-brr[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
