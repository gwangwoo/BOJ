import java.util.*;
import java.io.*;

public class _1753_최단경로 {
	static ArrayList<Pair> adj[];
	static int dist[];
	static int V,E,S;
	
	static void dijkstra(int s) {
		for(int i = 1 ; i <= V ; i++) dist[i] = (int)1e9;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Pair(dist[s],s));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			for(Pair y : adj[p.vertex]) {
				if(dist[y.vertex] > dist[p.vertex] + y.weight) {
					dist[y.vertex] = dist[p.vertex] + y.weight;
					pq.add(new Pair(dist[y.vertex], y.vertex));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine());
		adj = new ArrayList[V+1];
		dist = new int[V+1];
		for(int i = 1 ; i <= V ; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Pair(w,v));
		}
		dijkstra(S);
		for(int i = 1 ; i <= V ; i++) {
			if(dist[i] != (int)1e9) {
				System.out.println(dist[i]);
			}else System.out.println("INF");
		}
		
	}
	static class Pair implements Comparable<Pair>{
		int weight;
		int vertex;
		Pair(int weight , int vertex) {
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

