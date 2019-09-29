import java.io.*;
import java.util.*;
public class _boj_17396 {
	static boolean visited[];
	static boolean check[];
	static int N,M;
	static long dist[];
	static ArrayList<Pair> arl[];

	static void dijk() {
		for(int i = 0 ; i < N ; i++) dist[i] = Long.MAX_VALUE;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[0] = 0;
		pq.add(new Pair(0,dist[0]));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			if(check[p.index]) continue;
			for(Pair y : arl[p.index]) {
				if(dist[y.index] > dist[p.index] + y.weight && !check[y.index]) {
					dist[y.index] = dist[p.index] + y.weight;
					pq.add(new Pair(y.index,dist[y.index]));
				}
			}
			check[p.index] = true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		check = new boolean[N];
		dist = new long[N];
		arl = new ArrayList[N];
		for(int i = 0 ; i < N ; i++) arl[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i= 0 ; i < N ; i++) {
			int val = Integer.parseInt(st.nextToken());
			if(val == 1) visited[i] = true;
			else visited[i] = false;
		}
		visited[N-1] = false;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			if(visited[u] || visited[v]) continue;
			arl[u].add(new Pair(v,weight));
			arl[v].add(new Pair(u,weight));
		}
		dijk();
		if(dist[N-1] != Long.MAX_VALUE) System.out.println(dist[N-1]);
		else System.out.println(-1);
	}
	static class Pair implements Comparable<Pair>{
		int index;
		long weight;
		Pair(int index, long weight) {
			this.index = index;
			this.weight = weight;
		}
		@Override
		public int compareTo(Pair target) {
			if(this.weight > target.weight) return 1;
			else if(this.weight < target.weight) return -1;
			return 0;
		}
	}


}

