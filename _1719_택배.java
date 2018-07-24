import java.io.*;
import java.util.*;

public class _1719_택배 {
	static int dist[];
	static int where[][];
	static ArrayList<Pair> adj[];
	static int V,E;
	
	static void dijk(int s) {
		for(int i = 1 ; i <= V ; i++) dist[i] = 10000000;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Pair(0,s));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			for(Pair y : adj[p.vertex]) {
				if(dist[y.vertex] > dist[p.vertex] + y.weight) {
					dist[y.vertex] = dist[p.vertex] + y.weight;
					where[s][y.vertex] = p.vertex;
					pq.add(new Pair(dist[y.vertex], y.vertex));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dist = new int[V+1];
		where = new int[V+1][V+1];
		adj = new ArrayList[V+1];
		for(int i = 1 ; i <= V ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Pair(w,v));
			adj[v].add(new Pair(w,u));
		}
		
		for(int i = 1 ; i <= V ; i++) {
			dijk(i);
		}
		
		for(int i = 1 ; i <= V ; i++) {
			for(int j = 1 ; j <= V ; j++) {
				if(i == j) {
					System.out.print('-' + " ");
					continue;
				}
				System.out.print(where[j][i]+ " ");
			}
			System.out.println();
		}
	}
	static class Pair implements Comparable<Pair> {
		int weight,vertex;
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
