import java.io.*;
import java.util.*;

public class _1238_파티 {
	static int V,E,X;
	static ArrayList<Pair> adj[];
	static boolean visited[];
	static int dist[][];
	
	static void dijk(int s) {
		for(int i = 1 ; i <= V ; i++) dist[s][i] = (int)1e9;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s][s] = 0;
		pq.add(new Pair(dist[s][s],s));
		while(!pq.isEmpty()) {
			Pair p;
			do {
				p = pq.poll();
			}while(!pq.isEmpty() && visited[p.vertex]);
			if(visited[p.vertex]) break;
			visited[p.vertex] = true;
			for(Pair y : adj[p.vertex]) {
				if(dist[s][y.vertex] > dist[s][p.vertex] + y.weight) {
					dist[s][y.vertex] = dist[s][p.vertex] + y.weight;
					pq.add(new Pair(dist[s][y.vertex], y.vertex));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[V+1];
		for(int i = 1 ; i <= V ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		visited = new boolean[V+1];
		dist = new int[V+1][V+1];
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Pair(w,v));
		}
		for(int i = 1 ; i <= V ;i++) { 
			Arrays.fill(visited, false);
			dijk(i);
		}
		int res = 0;
		for(int i = 1 ; i <= V ; i++) {
			res = Math.max(res,dist[X][i] + dist[i][X]);
		}
		System.out.println(res);
	}
	static class Pair implements Comparable<Pair>{
		int weight;
		int vertex;
		Pair(int weight, int vertex) {
			this.weight = weight;
			this.vertex = vertex;
		}
		@Override
		public int compareTo(Pair target) {
			if(this.weight > target.weight) return 1;
			else return -1;
		}
	}
}
