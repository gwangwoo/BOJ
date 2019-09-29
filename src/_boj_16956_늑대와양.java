import java.io.*;
import java.util.*;

public class _boj_16956_늑대와양 {
	static int R,C;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static char map[][];
	
	static void imPound(Point now) {
		for(int k = 0 ; k < 4 ; k++) {
			int nr = now.r + dr[k];
			int nc = now.c + dc[k];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if(map[nr][nc] == 'S') continue;
			if(map[nr][nc] == 'W') {
				System.out.println(0);
				System.exit(0);
			}
			if(map[nr][nc] == '.') {
				map[nr][nc] = 'D';
			}
		}
	}
	
	static ArrayList<Point> wolf = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					wolf.add(new Point(i,j));
				}
			}
		}
		for(Point y : wolf) {
			imPound(y);
		}
		System.out.println(1);
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
