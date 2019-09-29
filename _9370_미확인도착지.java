//hg와 gh의 길이를 고려해줘야한다.
import java.io.*;
import java.util.*;

public class _9370_미확인도착지 {
	static int N,M,T;
	static ArrayList<Node> adj[];
	static ArrayList<Integer> dest;
	static int dist1[];
	static int dist2[];
	static int start,g,h;

	static void dijk(int s, int[] dist) {
		for(int i =1 ; i <= N ; i++) dist[i] = (int)1e9;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Node(dist[s],s));
		while(!pq.isEmpty()) {
			Node p = pq.poll();
			for(Node y : adj[p.vertex]) {
				if(dist[y.vertex] > dist[p.vertex] + y.weight) {
					dist[y.vertex] = dist[p.vertex] + y.weight;
					pq.add(new Node(dist[y.vertex],y.vertex));
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[N+1];
			dist1 = new int[N+1];
			dist2 = new int[N+1];
			for(int i = 1 ; i <= N ; i++) {
				adj[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				adj[u].add(new Node(w,v));
				adj[v].add(new Node(w,u));
			}
			
			dest = new ArrayList<>();
			for(int i = 0 ; i < T ; i++) {
				dest.add(Integer.parseInt(br.readLine()));
			}
			
			dijk(start, dist1);
			int mid = dist1[g] < dist1[h]? h:g;
			dijk(mid, dist2);
			ArrayList<Integer> ans = new ArrayList<>();
			for(int y : dest) {
				if(dist1[mid] + dist2[y] == dist1[y])
					ans.add(y);
			}
			Collections.sort(ans);
			for(int y : ans) {
				System.out.print(y+ " ");
			}
			System.out.println();
		}
	}
	static class Node implements Comparable<Node> {
		int weight, vertex;
		Node(int weight, int vertex) {
			this.weight = weight;
			this.vertex = vertex;
		}
		@Override
		public int compareTo(Node target) {
			if(this.weight > target.weight) return 1;
			else if(this.weight == target.weight) return 0;
			else return -1;
		}
	}
}
