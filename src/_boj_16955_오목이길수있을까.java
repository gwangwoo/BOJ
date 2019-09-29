import java.util.*;
import java.io.*;

// X'는 구사과의 돌, 'O'는 큐브러버의 돌이다.
public class _boj_16955_오목이길수있을까 {
	static final int N = 10;
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	// ㅡ dir
	static int coldr[] = {0,0};
	static int coldc[] = {-1,1};
	// | dir
	static int rowdr[] = {-1,1};
	static int rowdc[] = {0,0};
	// / dir
	static int updr[] = {-1,1};
	static int updc[] = {1,-1};
	// \ dir
	static int downdr[] = {-1,1};
	static int downdc[] = {-1,1};
	static char map[][] = new char[N][N];
	static ArrayList<Point> cand = new ArrayList<>();

	static boolean isOmok(int sr,int sc) {

		// 4번 bfs 실행해서 하나라도 만족한다면 그건 true
		Queue<Point> q = new LinkedList<>();
		boolean check[][] = new boolean[N][N];
		q.add(new Point(sr,sc));
		check[sr][sc] = true;
		int cnt = 1;
		// ㅡ 검사.
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			for(int k = 0 ; k < 2 ; k++) {
				int nr = r + coldr[k];
				int nc = c + coldc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc]== 'X' && !check[nr][nc]) {
					q.add(new Point(nr,nc));
					check[nr][nc] = true;
					cnt++;
				}
			}
		}
		if(cnt >= 5) return true;
		// | 검사
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(check[i], false);
		}
		q.clear();
		q.add(new Point(sr,sc));
		cnt = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			for(int k = 0 ; k < 2 ; k++) {
				int nr = r + rowdr[k];
				int nc = c + rowdc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc]== 'X' && !check[nr][nc]) {
					q.add(new Point(nr,nc));
					check[nr][nc] = true;
					cnt++;
				}
			}
		}
		if(cnt >= 5) return true;
		// / 검사
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(check[i], false);
		}
		q.clear();
		q.add(new Point(sr,sc));
		cnt = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			for(int k = 0 ; k < 2 ; k++) {
				int nr = r + updr[k];
				int nc = c + updc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc]== 'X' && !check[nr][nc]) {
					q.add(new Point(nr,nc));
					check[nr][nc] = true;
					cnt++;
				}
			}
		}
		if(cnt >= 5) return true;
		
		// \ 검사.
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(check[i], false);
		}
		q.clear();
		q.add(new Point(sr,sc));
		cnt = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			for(int k = 0 ; k < 2 ; k++) {
				int nr = r + downdr[k];
				int nc = c + downdc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc]== 'X' && !check[nr][nc]) {
					q.add(new Point(nr,nc));
					check[nr][nc] = true;
					cnt++;
				}
			}
		}
		if(cnt >= 5) return true;
		
		return false;
	}

	static boolean isCand(int r,int c) {
		int x_cnt = 0;
		for(int k = 0 ; k < 8 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(map[nr][nc] == 'X') x_cnt++;
		}
		if(x_cnt == 0) return false;
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(isCand(i,j) && map[i][j] == '.') cand.add(new Point(i,j));
			}
		}
			
		for(Point y : cand) {
			if(isOmok(y.r,y.c)) {
				System.out.println(1);
				return;
			}
		}
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
