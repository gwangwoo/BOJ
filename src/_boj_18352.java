import java.io.*;
import java.util.*;
public class _boj_18352 {
	static int N,M,K,X;
	static ArrayList<Edge> arl[];
	static int dist[];
	
	static void dijk(int s) {
		dist = new int[N+1];
		for(int i = 1 ; i <= N ; i++) dist[i] = (int)1e9;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new Edge(s,dist[s]));
		while(!pq.isEmpty()) {
			Edge p = pq.poll();
			for(Edge y : arl[p.vertex]) {
				if(dist[y.vertex] > dist[p.vertex] + y.weight) {
					dist[y.vertex] = dist[p.vertex] + y.weight;
					pq.add(new Edge(y.vertex,dist[y.vertex]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arl = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) arl[i] = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arl[u].add(new Edge(v,1));
		}
		
		dijk(X);
		int cnt = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i =1 ; i <= N ; i++) {
			if(dist[i] == K) {
				bw.write(i+"\n");
				cnt++;
			}
		}
		if(cnt == 0) bw.write(-1+"");
		bw.flush();
	}
	static class Edge implements Comparable<Edge>{
		int vertex,weight;
		Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge target) {
			return this.weight - target.weight;
		}
		
	}
}
