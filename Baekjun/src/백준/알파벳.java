package ¹éÁØ;

import java.util.*;

public class ¾ËÆÄºª {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static char map[][];
	static boolean check[];
	static int R,C;
	static int ans = 1;
	static int cnt = 1;
	public static void dfs(char[][] map, boolean[] chekc, int x, int y) {
		char idx = map[x][y];
		
		check[idx] = true;

		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(-1 < nx && nx < R && -1 < ny && ny < C) {
				char next = map[nx][ny];
				if(!check[next]) {
					ans = Math.max(++cnt, ans);
					dfs(map, check, nx, ny);
				}

			}
		}
		--cnt;
		check[idx] = false;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		check = new boolean[100];
		for(int i = 0 ; i < R ; i++) {
			String str = sc.next();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
	//			System.out.print(map[i][j] + " ");
			}
	//		System.out.println();
		}
		dfs(map,check,0,0);
		System.out.println(ans);
	}

}
