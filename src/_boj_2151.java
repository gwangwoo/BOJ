import java.io.*;
import java.util.*;
public class _boj_2151 {
	static int N;
	static char map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static Point s;

	static int bfs() {
		boolean visited[][] = new boolean[N][N];
		
		visited[s.r][s.c] = true;
		PriorityQueue<Point> q = new PriorityQueue<>();
		for(int i = 0 ; i < 4 ; i++) {
			q.add(new Point(s.r,s.c,0,i));
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt;
			int dir = p.dir;

			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == '*') continue;

			if(map[nr][nc] == '#') {
				return cnt;
			}else if(map[nr][nc] == '!') {
				// 거울 설치안하고 그냥 가는 경우.
				q.add(new Point(nr,nc,cnt,dir));
				// \ 설치.
				if(dir-1 < 0) {
					q.add(new Point(nr,nc,cnt+1,3));
				}else q.add(new Point(nr,nc,cnt+1,dir-1));
				// / 설치.
				if(dir+1 > 3) {
					q.add(new Point(nr,nc,cnt+1,0));
				}else q.add(new Point(nr,nc,cnt+1,dir+1));
				visited[nr][nc] = true;
			}else {
				q.add(new Point(nr,nc,cnt,dir));
				visited[nr][nc] = true;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '#') {
					s = new Point(i,j,0,0);
				}
			}
		}
		System.out.println(bfs());



	}
	static class Point implements Comparable<Point>{
		int r,c,cnt,dir;
		Point(int r,int c,int cnt,int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
		@Override
		public int compareTo(Point target) {
			if(this.cnt < target.cnt) return -1;
			else if(this.cnt > target.cnt) return 1;
			return 0;
		}
	}
}

