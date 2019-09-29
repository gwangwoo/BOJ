import java.io.*;
import java.util.*;

public class _boj_16926_배열돌리기1 {
	static int N,M,R;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 겉에 쪽 부터
		// depth 구하기.
		int depth = Math.min(M, N) / 2;
		for(int i = 0 ; i < depth ; i++) {
			for(int j = 0 ; j < R % (2 * (N + M - 2 - 4 * i)) ; j++) {
				int y = i, x = i;
				int tmp = map[i][i];
				// moving up;
				while(y < N - 1 - i) {
					int tmp2 = map[y+1][x];
					map[y+1][x] = tmp;
					tmp = tmp2;
					y++;
				}
				// moving left;
				while(x < M - 1 - i) {
					int tmp2 = map[y][x+1];
					map[y][x+1] = tmp;
					tmp = tmp2;
					x++;
				}
				// moving down;
				while(y > i) {
					int tmp2 = map[y-1][x];
					map[y-1][x] = tmp;
					tmp = tmp2;
					y--;
				}
				// moving right;
				while(x > i) {
					int tmp2 = map[y][x-1];
					map[y][x-1] = tmp;
					tmp = tmp2;
					x--;
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
