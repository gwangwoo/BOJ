import java.io.*;
import java.util.*;

public class _boj_2931_가스관 {
	static int R,C;
	static char dir[] = {'|','-','+','1','2','3','4'};
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static Point M,Z;
	static char map[][];

	static boolean isRight(int sr,int sc, int i) {
		switch(i) {
		case 0:
			int nr = sr + dr[0];
			int nc = sc + dc[0];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') return false;
			if(map[nr][nc] == '-' || map[nr][nc] == '2' || map[nr][nc] == '3') return false;
			int br = sr + dr[2];
			int bc = sc + dc[2];
			if(br < 0 || br >= R || bc < 0 || bc >= C || map[br][bc] == '.') return false;
			if(map[br][bc] == '-' || map[br][bc] == '1' || map[br][bc] == '4') return false;
			nr = sr + dr[1];
			nc = sc + dc[1];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) return false;
			if(map[nr][nc] == '-' || map[nr][nc] == '+' || map[nr][nc] == '3' || map[nr][nc] == '4') return false;
			nr = sr + dr[3];
			nc = sc + dc[3];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) return false;
			if(map[nr][nc] == '-' || map[nr][nc] == '+' || map[nr][nc] == '2' || map[nr][nc] == '1') return false;
			map[sr][sc] = dir[0];
			return true;
		case 1:
			nr = sr + dr[1];
			nc = sc + dc[1];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') return false;
			if(map[nr][nc] == '|' || map[nr][nc] == '1' || map[nr][nc] == '2') return false;
			br = sr + dr[3];
			bc = sc + dc[3];
			if(br < 0 || br >= R || bc < 0 || bc >= C || map[br][bc] == '.') return false;
			if(map[br][bc] == '|' || map[br][bc] == '3' || map[br][bc] == '4') return false;
			nr = sr + dr[0];
			nc = sc + dc[0];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) return false;
			if(map[nr][nc] == '|' || map[nr][nc] == '+' || map[nr][nc] == '1' || map[nr][nc] == '4') return false;
			nr = sr + dr[2];
			nc = sc + dc[2];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) return false;
			if(map[nr][nc] == '|' || map[nr][nc] == '+' || map[nr][nc] == '2' || map[nr][nc] == '3') return false;
			
			
			map[sr][sc] = dir[1];
			return true;
		case 2:
			nr = sr + dr[0];
			nc = sc + dc[0];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') return false;
			if(map[nr][nc] == '-' || map[nr][nc] == '2' || map[nr][nc] == '3') return false;
			br = sr + dr[2];
			bc = sc + dc[2];
			if(br < 0 || br >= R || bc < 0 || bc >= C || map[br][bc] == '.') return false;
			if(map[br][bc] == '-' || map[br][bc] == '1' || map[br][bc] == '4') return false;
			nr = sr + dr[1];
			nc = sc + dc[1];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') return false;
			if(map[nr][nc] == '|' || map[nr][nc] == '1' || map[nr][nc] == '2') return false;
			br = sr + dr[3];
			bc = sc + dc[3];
			if(br < 0 || br >= R || bc < 0 || bc >= C || map[br][bc] == '.') return false;
			if(map[br][bc] == '|' || map[br][bc] == '3' || map[br][bc] == '4') return false;
			map[sr][sc] = dir[2];
			return true;
		case 3:
			nr = sr + dr[1];
			nc = sc + dc[1];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') return false;
			if(map[nr][nc] == '|' || map[nr][nc] == '2' || map[nr][nc] == '1') return false;
			br = sr + dr[2];
			bc = sc + dc[2];
			if(br < 0 || br >= R || bc < 0 || bc >= C || map[br][bc] == '.') return false;
			if(map[br][bc] == '-' || map[br][bc] == '4' || map[br][bc] == '1') return false;
			map[sr][sc] = dir[3];
			return true;
		case 4:
			nr = sr + dr[0];
			nc = sc + dc[0];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') return false;
			if(map[nr][nc] == '-' || map[nr][nc] == '3' || map[nr][nc] == '2') return false;
			br = sr + dr[1];
			bc = sc + dc[1];
			if(br < 0 || br >= R || bc < 0 || bc >= C || map[br][bc] == '.') return false;
			if(map[br][bc] == '|' || map[br][bc] == '1' || map[br][bc] == '2') return false;
			map[sr][sc] = dir[4];
			return true;
		case 5:
			nr = sr + dr[3];
			nc = sc + dc[3];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') return false;
			if(map[nr][nc] == '|' || map[nr][nc] == '4' || map[nr][nc] == '3') return false;
			br = sr + dr[0];
			bc = sc + dc[0];
			if(br < 0 || br >= R || bc < 0 || bc >= C || map[br][bc] == '.') return false;
			if(map[br][bc] == '-' || map[br][bc] == '2' || map[br][bc] == '3') return false;
			map[sr][sc] = dir[5];
			return true;
		case 6:
			nr = sr + dr[3];
			nc = sc + dc[3];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') return false;
			if(map[nr][nc] == '|' || map[nr][nc] == '4' || map[nr][nc] == '3') return false;
			br = sr + dr[2];
			bc = sc + dc[2];
			if(br < 0 || br >= R || bc < 0 || bc >= C || map[br][bc] == '.') return false;
			if(map[br][bc] == '-' || map[br][bc] == '4' || map[br][bc] == '1') return false;
			map[sr][sc] = dir[6];
			return true;
		}
		return false;
	}


	static void bfs(int sr,int sc) {
		Queue<Point> q = new LinkedList<>();
		for(int k = 0 ; k < 4 ; k++) {
			int nr = sr + dr[k];
			int nc = sc + dc[k];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if(map[nr][nc] != '.') q.add(new Point(sr,sc,k));
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			int d = p.d;

			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if(map[nr][nc] == '|' && (d == 0 || d == 2)) {
				q.add(new Point(nr,nc,d));
			}else if(map[nr][nc] == '-' && (d == 1 || d == 3)) {
				q.add(new Point(nr,nc,d));
			}else if(map[nr][nc] == '+') {
				q.add(new Point(nr,nc,d));
				q.add(new Point(nr,nc,(d+1)%4));
				if(d == 0 ) d = 4;
				q.add(new Point(nr,nc,(d-1)%4));
			}else if(map[nr][nc] == '1') {
				if(d == 0) {
					q.add(new Point(nr,nc,1));
				}else if(d == 3) {
					q.add(new Point(nr,nc,2));
				}
			}else if(map[nr][nc] == '2') {
				if(d == 2) {
					q.add(new Point(nr,nc,1));
				}else if(d == 3) {
					q.add(new Point(nr,nc,0));
				}
			}else if(map[nr][nc] == '3') {
				if(d == 2) {
					q.add(new Point(nr,nc,3));
				}else if(d == 1) {
					q.add(new Point(nr,nc,0));
				}
			}else if(map[nr][nc] == '4') {
				if(d == 1) {
					q.add(new Point(nr,nc,2));
				}else if(d == 0) {
					q.add(new Point(nr,nc,3));
				}
			}else if(map[nr][nc] == '.') {
				System.out.print((nr+1) + " " + (nc+1) + " ");
				for(int k = 0 ; k < 7 ; k ++) {
					//map[nr][nc] = dir[k];
					if(isRight(nr,nc,k)) {
						System.out.print(dir[k]);
						System.out.println();
						return;
					}
					else continue;
				}
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'M') {
					M = new Point(i,j,0);
				}else if(map[i][j] == 'Z') {
					Z = new Point(i,j,0);
				}
			}
		}
		bfs(M.r,M.c);
	}
	static class Point {
		int r,c,d;
		Point(int r,int c,int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}