import java.io.*;
import java.util.*;

public class _2398_3인통화 {
	static int V,E;
	static int dist[][], from[][];
	static ArrayList<Pair> adj[];
	static int m[] = new int[3];
	static boolean visited[];
	
	static void dijk(int s) {
		for(int i = 1 ; i <= V ; i++) dist[s][i] = (int)1e9;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s][m[s]] = 0;
		from[s][m[s]] = -1;
		pq.add(new Pair(dist[s][m[s]],m[s]));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			for(Pair y : adj[p.vertex]) {
				if(dist[s][y.vertex] > dist[s][p.vertex] + y.weight) {
					dist[s][y.vertex] = dist[s][p.vertex] + y.weight;
					from[s][y.vertex] = p.vertex;
					pq.add(new Pair(dist[s][y.vertex] , y.vertex));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[V+1];
		dist = new int[3][V+1];
		from = new int[3][V+1];
		visited = new boolean[V+1];
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
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m.length ; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		dijk(0);
		dijk(1);
		dijk(2);
		int mini = (int)1e9;
		int pos = 0;
		for(int i = 1 ; i <= V ; i++) {
			System.out.println(dist[0][i] + dist[1][i] + dist[2][i]);
			
			if(mini > dist[0][i] + dist[1][i] + dist[2][i]) {
				mini = dist[0][i] + dist[1][i] + dist[2][i];
				pos = i;
			}
		}
		ArrayList<Point> path = new ArrayList<>();
		for(int i = 0 ; i < 3 ; i++) 
			for(int j = pos ; from[i][j] != -1 ; j = from[i][j])
				path.add(new Point(j,from[i][j]));
		System.out.println(mini + " " + path.size());
		for(Point y : path) System.out.println(y.first + " " +  y.second);
		
	}
	static class Point {
		int first,second;
		Point(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int weight,vertex;
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
