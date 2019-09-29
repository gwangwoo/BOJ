import java.io.*;
import java.util.*;

public class _boj_8976_LAGNO {
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	static final int N = 8;
	static ArrayList<Point> cand;
	static char map[][];
	
	public static void main(String[] args) throws IOException{
		// 검은색 플레이어가 한번의 수로 얼마나 많은 W를 넘길수있는지를 검사하는 문제.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[N][N];
		cand = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 'W') {
					for(int k = 0 ; k < 8 ; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != '.') continue;
						map[nr][nc] = 'x';
						cand.add(new Point(nr,nc));
					}
				}
			}
		}
		
		for(int i = 0 ; i < cand.size() ; i++) {
			int r = cand.get(i).r;
			int c = cand.get(i).c;
			map[r][c] = 'B';
//			dfs(r,c,map[r][c]);
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
