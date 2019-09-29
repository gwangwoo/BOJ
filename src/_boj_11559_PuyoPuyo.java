import java.io.*;
import java.util.*;

public class _boj_11559_PuyoPuyo {	
	static final int N = 12;
	static final int M = 6;
	static char map[][] = new char[N][M];
	static boolean check[][] = new boolean[N][M];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};

	static void moveDown(int r,int c) {
		for(int i = r+1 ; i < N ; i++) {
			if(map[i][c] == '.') {
				map[i][c] = map[r][c];
				map[r][c] = '.';
				r = i;
				continue;
			}else return;
		}
	}

	static int bfs(int r,int c) {
		int cnt = 1;
		ArrayList<Point> arr = new ArrayList<>();
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		arr.add(new Point(r,c));
		check[r][c] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r;
			c = p.c;

			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || check[nr][nc]) continue;
				if(map[r][c] == map[nr][nc]) {
					q.add(new Point(nr,nc));
					check[nr][nc] = true;
					arr.add(new Point(nr,nc));
					cnt++;
				}
			}
		}
		if(cnt >= 4) {
			for(int i = 0 ; i < arr.size() ; i++) {
				map[arr.get(i).r][arr.get(i).c] = '.';
			}
			return 1;
		}else return 0;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0; j < M ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int ans = 0;
		// 터지기.
		while(true) {
			for(int i = 0 ; i < N ; i++) {
				Arrays.fill(check[i], false);
			}
			int cnt = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j] == 'P' || map[i][j] == 'R' || map[i][j] == 'B' || map[i][j]== 'G'
							|| map[i][j] == 'Y') {
						if(!check[i][j]) {
							cnt += bfs(i,j);
						}
					}
				}
			}
			if(cnt == 0) {
				break;
			}else ans++;
			// 내리기.
			for(int i = 0 ; i < M ; i++) {
				for(int j = N-1 ; j > 0 ; j--) {
					if(map[j][i] == '.' && map[j-1][i] != '.') {
						moveDown(j-1,i);
					}
				}
			}
		}
		System.out.println(ans);


	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
