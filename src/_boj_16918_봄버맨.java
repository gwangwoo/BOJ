import java.io.*;
import java.util.*;

public class _boj_16918_봄버맨 {
	static int R,C,N;
	static char map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int check[][];

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'O') {
					check[i][j] = 1;
				}
			}
		}
		if(N == 1) {
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		if(N > 5) {
			N %= 4;
			if(N == 0) {
				N = 2;
			}else if(N == 1) {
				N = 5;
			}
		}
		int time = 0;
		while(time != N) {
			time++;
			if(time == N) break;
			if(time % 2 == 1) {
				// 빈곳에 폭탄심기.
				for(int i = 0 ; i < R ; i++) {
					for(int j = 0 ; j < C ; j++) {
						if(map[i][j] == '.') {
							map[i][j] = 'O';
						}
					}
				}
			}else {
				for(int i = 0 ; i < R ; i++) {
					for(int j = 0 ; j < C ; j++) {
						if(check[i][j] > 0) {
							map[i][j] = '.';
							for(int k = 0 ; k < 4 ; k++) {
								int nr = i + dr[k];
								int nc = j + dc[k];
								if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
								map[nr][nc] = '.';
							}
						}
					}
				}
				for(int i = 0 ; i < R ; i++) {
					for(int j = 0 ; j < C ; j++) {
						check[i][j] = 0;
					}
				}

				for(int i = 0 ; i < R ; i++) {
					for(int j = 0 ; j < C ; j++) {
						if(map[i][j] == 'O') check[i][j] = 1;
					}
				}
			}

		}
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}