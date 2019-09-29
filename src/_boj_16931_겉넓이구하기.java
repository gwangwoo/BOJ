import java.util.*;
import java.io.*;


public class _boj_16931_겉넓이구하기 {
	static int N,M;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = N*M*2;
		
		// watch top
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ;  j < N-1 ; j++) {
				int diff = map[j][i] - map[j+1][i];
				if(diff > 0) res += diff;
			}
			res += map[N-1][i];
		}
		// watch left
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M-1 ; j++) {
				int diff = map[i][j] - map[i][j+1];
				if(diff > 0) res += diff;
			}
			res += map[i][M-1];
		}
		// watch bottom
		for(int i = 0 ; i < M ; i++) {
			for(int j = N-1 ; j > 0 ; j--) {
				int diff = map[j][i] - map[j-1][i];
				if(diff > 0) res += diff;
			}
			res += map[0][i];
		}
		// watch right
		for(int i = 0 ; i < N ; i++) {
			for(int j = M-1 ; j > 0 ; j--) {
				int diff = map[i][j] - map[i][j-1];
				if(diff > 0) res += diff;
			}
			res += map[i][0];
		}
		System.out.println(res);
		
	}

}
