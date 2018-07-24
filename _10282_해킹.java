import java.io.*;
import java.util.*;

public class _10282_해킹 {
	static ArrayList<Pair> adj[];
	static int dist[];
	static int n,d,c;
	
	static void dijk(int s) {
		for(int i = 1 ; i <= n ; i++) dist[i] = (int)1e9;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Pair(dist[s],s));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			for(Pair y : adj[p.vertex]) {
				if(dist[y.vertex] > dist[p.vertex] + y.weight) {
					dist[y.vertex] = dist[p.vertex] + y.weight;
					pq.add(new Pair(dist[y.vertex] , y.vertex));
				}
			}
		}
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[n+1];
			dist = new int[n+1];
			for(int i = 1 ; i <= n ; i++) {
				adj[i] = new ArrayList<>();
			}
			for(int i = 0 ; i < d ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				adj[b].add(new Pair(w,a));
			}
			
			dijk(c);
			int count = 0;
			int time = 0;
			for(int i = 1 ; i <= n ; i++) {
				if(dist[i] != (int)1e9) count++;
			}
			for(int i = 1 ; i <= n ; i++) {
				if(dist[i] !=(int)1e9 && dist[i] > time) {
					time = dist[i];
				}
			}
			System.out.println(count + " " + time);
		}
		
	}
	static class Pair implements Comparable<Pair> {
		int weight, vertex;
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
