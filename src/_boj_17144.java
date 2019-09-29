import java.io.*;
import java.util.*;

public class _boj_17144 {
	static int R,C,T;
	static int map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static Point S;
	static ArrayList<Point> arr;
	// top
	static void top(int tmp[][]) {
		int r = S.r-1;
		int c = S.c;
		// 아래로.
		for(int i = r-1 ; i >= 0 ; i--) {
			tmp[i+1][c] = tmp[i][c];
		}
		// 왼쪽으로.
		for(int j = 0 ; j < C-1 ; j++) {
			tmp[0][j] = tmp[0][j+1];
		}
		// 위로.
		for(int i = 0 ; i < r ; i++) {
			tmp[i][C-1] = tmp[i+1][C-1];
		}
		// 오른쪽으로.
		for(int j = C-1 ; j >= 2 ; j--) {
			tmp[r][j] = tmp[r][j-1];
		}
		tmp[r][c+1] = 0;
	}
	// bottom
	static void bottom(int tmp[][]) {
		int r = S.r;
		int c = S.c;
		// 위로.
		for(int i = r+1 ; i < R-1 ; i++) {
			tmp[i][c] = tmp[i+1][c];
		}
		// 왼쪽으로.
		for(int j = 0 ; j < C-1 ; j++) {
			tmp[R-1][j] = tmp[R-1][j+1];
		}
		// 아래로.
		for(int i = R-1 ; i > r ; i--) {
			tmp[i][C-1] = tmp[i-1][C-1];
		}
		// 오른쪽으로.
		for(int j = C-1 ; j >= 2 ; j--) {
			tmp[r][j] = tmp[r][j-1];
		}
		tmp[r][c+1] = 0;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		arr = new ArrayList<>();
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					S = new Point(i,j);
				}else if(map[i][j] != 0){
					arr.add(new Point(i,j));
				}
			}
		}
		int time = 0;
		int tmp[][] = new int[R][C];
		while(true) {
			if(time == T) break;
			time++;
			// 확산
			for(Point y : arr) {
				int cnt = 0;
				for(int k = 0 ; k < 4 ; k++) {
					int nr = y.r + dr[k];
					int nc = y.c + dc[k];
					if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
					cnt++;
					tmp[nr][nc] += map[y.r][y.c] / 5;
				}
				tmp[y.r][y.c] += map[y.r][y.c] - (map[y.r][y.c]/5) * cnt;
			}
			// top
			top(tmp);
			// bottom
			bottom(tmp);
			tmp[S.r-1][S.c] = -1;
			tmp[S.r][S.c] = -1;
			arr.clear();
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++) {
					if(tmp[i][j] != -1 && tmp[i][j] != 0) arr.add(new Point(i,j));
					map[i][j] = tmp[i][j];
					tmp[i][j] = 0;
				}
			}
		}
		int res = 0;
		for(int i = 0; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] != -1 ) res += map[i][j];
			}
		}
		System.out.println(res);

	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
