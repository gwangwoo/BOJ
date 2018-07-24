import java.io.*;
import java.util.*;

public class _11779_최소비용구하기2 {
	static int V,E;
	static int dist[];
	static ArrayList<Pair> adj[];
	static int from[];

	static void dijk(int s) {
		for(int i = 1 ; i <= V ; i++) dist[i] = (int)1e9;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Pair(dist[s],s));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			for(Pair y : adj[p.vertex]) {
				if(dist[y.vertex] > dist[p.vertex] + y.weight) {
					dist[y.vertex] = dist[p.vertex] + y.weight;
					from[y.vertex] = p.vertex;
					pq.add(new Pair(dist[y.vertex],y.vertex));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		dist = new int[V+1];
		from = new int[V+1];
		adj = new ArrayList[V+1];
		for(int i = 1 ; i <= V ; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0 ; i < E ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[u].add(new Pair(w,v));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m1,m2;
		m1 = Integer.parseInt(st.nextToken());
		m2 = Integer.parseInt(st.nextToken());
		dijk(m1);
		System.out.println(dist[m2]);
		int res = from[m2];
		int count = 1;
		for(int i = m2; i != m1; i = from[i]) count++;
		System.out.println(count);

		Stack<Integer> stk = new Stack<>();
		for(int i = m2 ; i != m1 ; i = from[i]) {
			stk.push(i);
		}
		stk.push(m1);

		while(!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
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
