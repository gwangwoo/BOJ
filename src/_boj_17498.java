import java.io.*;
import java.util.*;
public class _boj_17498 {
	static int N,M,D;
	static int dr[] = {1,0,0};
	static int dc[] = {0,1,-1};
	static long dp[][];
	static int map[][];
	static long res = -(long)1e10;
	static final long INF = (long)1e10;


	static void init() {
		for(int i = 1; i  < N ; i++) {
			for(int j = 0 ; j < M; j++) {
				dp[i][j] = -INF;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new long[N][M];
		init();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				for(int k = 1 ; (k <= D && i-k >= 0) ; k++) {
					for(int l = -(D-k) ; (l <= D-k && l+j < M) ; l++) {
						int ni = i-k;
						int nj = j+l;
						if(nj < 0) continue;
						dp[i][j] = Math.max(dp[ni][nj]+(map[i][j]*map[ni][nj]), dp[i][j]);
					}
				}
			}
		}

		// 갈수 있는 곳을 뽑아오자.
		for(int i = 0 ; i < M ; i++) {
			res = Math.max(res, dp[N-1][i]);
		}
		System.out.println(res);

	}
}
