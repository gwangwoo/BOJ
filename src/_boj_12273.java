import java.io.*;
import java.util.*;

public class _boj_12273 {
	static int map[][] = new int[100][100];
	static boolean visited[][] = new boolean[100][100];
	static int N,M;
	static int res;
	static int sr,sc,er,ec;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static PriorityQueue<Pair> q = new PriorityQueue<>();

	static void init() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				visited[i][j] = false;
			}
		}
	}

	static void bfs(int sr,int sc) {
		q.clear();
		q.add(new Pair(sr,sc,0,map[sr][sc]));
		visited[sr][sc] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int r = p.r;
			int c = p.c;
			int dist = p.dist;
			int val = p.val;

			if(r == er && c == ec) {
				res = val;
				return;
			}

			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == -1) continue;
				q.add(new Pair(nr,nc,dist-1,val+map[nr][nc]));
			}

		}



	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			init();
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			res = 0;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ;j < M ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(sr,sc);
			if(res == 0) System.out.println("Case #"+tc+": Mission Impossible.");
			else System.out.println("Case #"+tc+": "+ res);

		}
	}
	static class Pair implements Comparable<Pair> {
		int r,c;
		int dist,val;
		Pair(int r,int c,int dist, int val) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.val = val;
		}
		@Override
		public int compareTo(Pair target) {
			if(this.dist > target.dist) return 1;
			else if(this.dist < target.dist) return 1;
			else {
				if(this.val > target.val) return -1;
				else if(this.val < target.val) return 1;
				else return 0;
			}
		}

	}
}
