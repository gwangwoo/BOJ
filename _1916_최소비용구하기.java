import java.io.*;
import java.util.*;

public class _1916_최소비용구하기 {
	static int V,E,start,end;
	static ArrayList<Pair> adj[];
	static boolean visited[];
	static int dist[];
	
	static void dijk(int s) {
		for(int i = 1 ; i <= V ; i++) dist[i] = (int)1e9;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Pair(dist[s], s));
		while(!pq.isEmpty()) {
			Pair p;
			do{
				p = pq.poll();
			}while(!pq.isEmpty() && visited[p.vertex]);
			if(visited[p.vertex]) break;
			visited[p.vertex] = true;
			for(Pair y : adj[p.vertex]) {
				if(dist[y.vertex] > dist[p.vertex] + y.weight) {
					dist[y.vertex] = dist[p.vertex] + y.weight;
					pq.add(new Pair(dist[y.vertex] , y.vertex));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		adj = new ArrayList[V+1];
		for(int i = 1 ; i<= V ; i++) {
			adj[i] = new ArrayList<>();
		}
		visited = new boolean[V+1];
		dist = new int[V+1];
		
		for(int i = 0 ; i < E ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Pair(w,v));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijk(start);
		System.out.println(dist[end]);
		
	}
	static class Pair implements Comparable<Pair> {
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
