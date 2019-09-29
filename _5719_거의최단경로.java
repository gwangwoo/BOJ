import java.io.*;
import java.util.*;

public class _5719_거의최단경로 {
	static int V,E,S,D;
	static ArrayList<Pair> adj[];
	static ArrayList<Pair> rev[];
	static int dist[];
	static boolean visited[][];
	
	static void dijk(int s) {
		for(int i = 0 ; i < V ; i++) dist[i] = (int)1e9;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Pair(dist[s],s));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			//if(visited[p.vertex]) break;
			//visited[p.vertex] = true;
			for(Pair y : adj[p.vertex]) {
				if(dist[y.vertex] > dist[p.vertex] + y.weight && !visited[p.vertex][y.vertex]) {
					dist[y.vertex] = dist[p.vertex] + y.weight;
					pq.add(new Pair(dist[y.vertex] , y.vertex));
				}
			}
		}
	}
	
	static void bfs(int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(end);
		while(!q.isEmpty()) {
			int now = q.poll();
			//if(now == S) continue;
			for(Pair y : rev[now]) {
				if(dist[now] == dist[y.vertex] + y.weight) {
					visited[y.vertex][now] = true;
					q.add(y.vertex);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if(V == 0 && E == 0) break;
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			adj = new ArrayList[V];
			rev = new ArrayList[V];
			dist = new int[V];
			visited = new boolean[V][V];
			for(int i = 0 ; i < V ; i++) {
				adj[i] = new ArrayList<>();
				rev[i] = new ArrayList<>();
			}
			for(int i = 0 ; i < E ; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				adj[u].add(new Pair(w,v));
				rev[v].add(new Pair(w,u));
			}
			dijk(S);
			bfs(D);
			dijk(S);
			if(dist[D] != (int)1e9) System.out.println(dist[D]);
			else System.out.println(-1);
		}
		
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
