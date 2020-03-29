import java.io.*;
import java.util.*;
public class _boj_18808 {
	static int N,M,K;
	static int map[][];

	static boolean isUse(int r,int c,int tmp[][]) {
		if(r+tmp.length > N || c + tmp[0].length > M) return false;
		for(int i = r ; i < r+tmp.length ; i++) {
			for(int j = c ; j < c+tmp[0].length ; j++) {
				if(tmp[i-r][j-c] == 1 && map[i][j] == 1) return false;
			}
		}
		// ok
		for(int i = r ; i < r+tmp.length ; i++) {
			for(int j = c ; j < c+tmp[0].length ; j++) {
				map[i][j] |= tmp[i-r][j-c];
			}
		}


		return true;
	}

	static int[][] rotate(int tmp[][]) {
		int n = tmp.length;
		int m = tmp[0].length;
		int tmp2[][] = new int[m][n];

		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				tmp2[j][n-i-1] = tmp[i][j];
			}
		}
		return tmp2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for(int x = 0 ; x < K ; x++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int tmp[][] = new int[n][m];
			for(int j = 0 ; j < n ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < m ; k++) {
					tmp[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			boolean flag = false;
			//			// rotate
			for(int ro = 0 ; ro < 4 ; ro++) {
				if(ro != 0) tmp = rotate(tmp);
				for(int i = 0 ; i < N ; i++) {
					for(int j = 0 ; j < M ;j++) {
						if(isUse(i,j,tmp)) {
							flag = true;
							break;
						}
					}
					if(flag) break;
				}
				if(flag) break;
			}
			if(flag) continue;
		}
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 1) res++;
			}
		}
		System.out.println(res);
	}

}
