import java.io.*;
import java.util.*;

public class _boj_16954_움직이는미로탈출 {
	static int dr[] = {-1,-1,-1,0,1,1,1,0,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1,0};
	static final int N = 8;
	static char map[][] = new char[N][N];
	static int sr = 7, sc = 0, er = 0 , ec = 7;
	static void map_Down() {
		for(int j = 0 ; j < N ; j++) {
			for(int i = 6 ; i >= 0 ; i--) {
				map[i+1][j] = map[i][j];
			}
			map[0][j] = '.';
		}
	}
	static void bfs(int r,int c) {
		int check[][] = new int[N][N];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		check[r][c] = 1;
		while(!q.isEmpty()) {
			int q_size = q.size();
			while(q_size-- > 0) {
				Point p = q.poll();
				r = p.r;
				c = p.c;
				
				if(r == er && c == ec) {
					System.out.println(1);
					System.exit(0);
				}
				if(map[r][c] == '#') continue;
				for(int k = 0 ; k < 9 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == '#') continue;
					if(check[nr][nc] >= 8) continue;
					q.add(new Point(nr,nc));
					check[nr][nc]++;
				}
			}
			map_Down();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		bfs(sr,sc);
		System.out.println(0);
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
