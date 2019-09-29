import java.io.*;
import java.util.*;

public class _boj_2151_거울설치 {
	static int N;
	static int sr,sc,er,ec;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static char map[][];
	static int check[][][];

	static int mir1(int dir) {
		if(dir == 0) return 1;
		else if(dir == 1) return 0;
		else if(dir == 2) return 3;
		return 2;
	}
	static int mir2(int dir) {
		if(dir == 0) return 3;
		else if(dir == 1) return 2;
		else if(dir == 2) return 1;
		else return 0;
	}
	
	static void bfs(int sr, int sc) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		check = new int[N][N][4];
		for(int i = 0 ; i < 4 ; i++) {
			q.add(new Point(sr,sc,i,0));
			check[sr][sc][i] = 1;
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			int dir = p.dir;
			int cnt = p.cnt;


			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || check[nr][nc][dir] != 0 || map[nr][nc] == '*') continue;
			if(map[nr][nc] == '.') {
				q.add(new Point(nr,nc,dir,cnt));
				check[nr][nc][dir] = 1;
			}else if(map[nr][nc] == '!') {
				q.add(new Point(nr,nc,dir,cnt));
				check[nr][nc][dir] = 1;
				// / 설치
				q.add(new Point(nr,nc,mir1(dir),cnt+1));
				check[nr][nc][mir1(dir)] = 1;
				// \ 설치
				q.add(new Point(nr,nc,mir2(dir),cnt+1));
				check[nr][nc][mir2(dir)] = 1;
			}else if(nr == er && nc == ec) {
				System.out.println(cnt);
				System.exit(0);
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		boolean flag = false;
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
				if(!flag && map[i][j] == '#') {
					flag = true;
					sr = i; sc = j;
				}else if(map[i][j] == '#') {
					er = i; ec = j;
				}
			}
		}
		bfs(sr,sc);
	}
	static class Point implements Comparable<Point>{
		int r,c,dir,cnt;
		Point(int r,int c,int dir,int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point target) {
			if(this.cnt < target.cnt) return -1;
			else if(this.cnt > target.cnt) return 1;
			return 0;
		}
	}
}
