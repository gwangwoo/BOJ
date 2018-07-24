import java.util.*;
import java.io.*;

public class _9372_상근이의여행 {
	static ArrayList<Integer> adj[];
	static int dist[];
	static boolean visited[];
	static int V,E;
	static int cnt = 0;
	
	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		dist[s] = 0;
		cnt = 0;
		q.add(s);
		while(!q.isEmpty()) {
			int p = q.poll();
			cnt++;
			for(int y : adj[p]) {
				if(!visited[y]) {
					dist[y] = dist[p] + 1;
					visited[y] = true;
					q.add(y);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adj = new ArrayList[V+1];
			for(int i = 1 ; i <= V ; i++) {
				adj[i] = new ArrayList<>();
			}
			dist = new int[V+1];
			visited = new boolean[V+1];
			for(int i = 0 ; i < E ; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			
			bfs(1);
			int res = 0;
			for(int i = 1 ; i <= V ; i++) {
				if(visited[i]) res++;
			}
			System.out.println(res-1);
		}
		
	}
}
