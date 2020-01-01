import java.io.*;
import java.util.*;
public class _boj_18223 {
	static int V,E,P;
	static int dist[][];
	static ArrayList<Point> arl[];
	
	static void dijk(int s) {
		boolean visited[] = new boolean[V+1];
		for(int i = 1 ; i <= V ; i++) dist[s][i] = (int)1e9;
		PriorityQueue<Point> pq = new PriorityQueue<>();
		visited[s] = true;
		dist[s][s] = 0;
		pq.add(new Point(s,dist[s][s]));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			for(Point y : arl[p.vertex]) {
				if(dist[s][y.vertex] > dist[s][p.vertex] + y.weight) {
					dist[s][y.vertex] = dist[s][p.vertex] + y.weight;
					pq.add(new Point(y.vertex,dist[s][y.vertex]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dist = new int[V+1][V+1];
		arl = new ArrayList[V+1];
		for(int i = 1 ; i <= V ; i++) {
			arl[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arl[u].add(new Point(v,w));
			arl[v].add(new Point(u,w));
		}
		
		dijk(1);
		dijk(P);
		if(dist[1][P] + dist[P][V] == dist[1][V]) {
			System.out.println("SAVE HIM");
		}else {
			System.out.println("GOOD BYE");
		}
		
		
	}
	static class Point implements Comparable<Point> {
		int vertex,weight;
		Point(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Point target) {
			if(this.weight < target.weight) return -1;
			else if(this.weight > target.weight) return 1;
			return 0;
		}
	}
}
