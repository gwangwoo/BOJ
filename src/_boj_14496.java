import java.io.*;
import java.util.*;

public class _boj_14496 {
	static int N,M,a,b;
	static ArrayList<Integer> arl[];
	static int dist[];
	static void dijk(int s) {
		dist = new int[N+1];
		boolean visited[] = new boolean[N+1];
		for(int i = 1 ; i <= N ; i++) dist[i] = (int)1e9;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[s] = 0;
		visited[s] = true;
		pq.add(new Node(s,dist[s]));
		while(!pq.isEmpty()) {
			Node p = pq.poll();
			for(int y : arl[p.vertex]) {
				if(visited[y]) continue;
				if(dist[y] > dist[p.vertex] + 1) {
					dist[y] = dist[p.vertex] + 1;
					visited[y] = true;
					pq.add(new Node(y,dist[y]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arl = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) arl[i] = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			arl[l].add(r);
			arl[r].add(l);
		}
		
		dijk(a);
		if(dist[b] == (int)1e9) System.out.println(-1);
		else System.out.println(dist[b]);
		
	}
	static class Node implements Comparable<Node>{
		int vertex,cnt;
		Node(int vertex, int cnt) {
			this.vertex = vertex;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node target) {
			return this.cnt - target.cnt;
		}
	}
}
