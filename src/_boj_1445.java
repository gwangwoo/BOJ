import java.io.*;
import java.util.*;

public class _boj_1445 {
	static int N,M;
	static char map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};

	static boolean check(int r,int c) {
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(map[nr][nc] == 'g') return true;
		}
		return false;
	}

	static String go(int sr,int sc) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean visited[][] = new boolean[N][M];
		pq.add(new Point(sr,sc,0,0));
		visited[sr][sc] = true;

		while(!pq.isEmpty()) {
			Point p = pq.poll();
			int r = p.r;
			int c = p.c;
			int gt = p.gt;
			int gs = p.gs;

			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				if(map[nr][nc] == 'F') {
					return gt + " " + gs;
				}else if(map[nr][nc] == 'g') {
					pq.add(new Point(nr,nc,gt+1,gs));
					visited[nr][nc] = true;
				}else if(check(nr,nc)) {
					pq.add(new Point(nr,nc,gt,gs+1));
					visited[nr][nc] = true;
				}else {
					pq.add(new Point(nr,nc,gt,gs));
					visited[nr][nc] = true;
				}
			}
		}
		return "";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int sr = -1, sc = -1;
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					sr = i;
					sc = j;
				}
			}
		}
		System.out.println(go(sr,sc));
	}
	static class Point implements Comparable<Point>{
		int r,c,gt,gs;
		Point(int r,int c,int gt,int gs) {
			this.r = r;
			this.c = c;
			this.gt = gt;
			this.gs = gs;
		}
		@Override
		public int compareTo(Point target) {
			if(this.gt < target.gt) return -1;
			else if(this.gt > target.gt) return 1;
			else {
				if(this.gs < target.gs) return -1;
				else if(this.gs > target.gs) return 1;
				else return 0;
			}
		}
	}
}
