import java.io.*;
import java.util.*;
public class _boj_17498 {
	static int N,M,D;
	static long dp[][];
	static int arr[][];
	static final long INF = (long)1e10;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new long[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				dp[i][j] = -INF;
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				for(int k = 1 ; k <= D && i-k >= 0 ; k++) {
					for(int l = -(D-k) ;  l <= (D-k) && l < M ; l++) {
						int ni = i-k;
						int nj = j+l;
						if(nj < 0 || nj >= M) continue;
						dp[i][j] = Math.max(dp[ni][nj]+arr[i][j]*arr[ni][nj], dp[i][j]); 
					}
				}
				
			}
		}
		long res = -INF;
		for(int i = 0; i < M ; i++) {
			res = Math.max(res, dp[N-1][i]);
		}
		System.out.println(res);
		
	}
}
