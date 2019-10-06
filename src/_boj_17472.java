import java.io.*;
import java.util.*;

public class _boj_17472 {
	static int N,M;
	static int arr[][];
	static int map[][];
	static boolean check[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int p[];
	static Queue<Point> q = new LinkedList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	
	static int find(int a) {
		if(p[a] < 0) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		if(p[a] < p[b]) {
			p[a] += p[b];
			p[b] = a;
		}else {
			p[b] += p[a];
			p[a] = b;
		}
		return true;
	}
	
	
	static void insert(int r, int c) {
		int now = map[r][c];
		for(int k = 0 ; k < 4 ; k++) {
			int cnt = 0;
			int nr = r + dr[k];
			int nc = c + dc[k];
			while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if(map[nr][nc] == now) break;
				if(map[nr][nc] != 0 && map[nr][nc] != now) {
					if(cnt == 1) break;
					pq.add(new Edge(now,map[nr][nc],cnt));
					pq.add(new Edge(map[nr][nc],now,cnt));
					break;
				}
				cnt++;
				nr += dr[k]; nc += dc[k];
			}
		}
	}
	
	static void bfs(int sr,int sc, int idx) {
		check[sr][sc] = true;
		map[sr][sc] = idx;
		q.add(new Point(sr,sc));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;

			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || check[nr][nc] || arr[nr][nc] != 1) continue;
				q.add(new Point(nr,nc));
				map[nr][nc] = idx;
				check[nr][nc] = true;
			}
		}



	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new boolean[N][M];
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int idx = 1;
		for(int i = 0 ; i < N ; i++) {
			for(int j =0 ; j <  M ; j++) {
				if(arr[i][j] == 1 && !check[i][j]) {
					bfs(i,j,idx++);
				}
			}
		}

		for(int y = 0 ; y < N ; y++) {
			for(int x = 0 ; x < M ; x++) {
				if(map[y][x] == 0) continue;
				insert(y,x);
			}
		}
		
		p = new int[idx];
		for(int i = 1; i < idx ; i++) p[i] = -1;
		
		
		int res = 0;
		int size = pq.size();
		while(size-- > 0) {
			Edge p  = pq.poll();
			if(union(p.u,p.v)) {
				res += p.weight;
			}
		}
		int cnt = 0;
		for(int i = 1 ; i < idx ; i++) {
			if(p[i] < 0) cnt++;
		}
		if(cnt == 1) System.out.println(res);
		else System.out.println(-1);
		
		
		
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Edge implements Comparable<Edge>{
		int u,v,weight;
		Edge(int u,int v,int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;

		}
		@Override
		public int compareTo(Edge target) {
			if(this.weight < target.weight) return -1;
			else if(this.weight > target.weight) return 1;
			return 0;
		}
	}
}
