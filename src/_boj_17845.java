import java.io.*;
import java.util.*;
public class _boj_17845 {
	static int N,K;
	static long dp[][] = new long[1001][10001];
	static int pri[];
	static int time[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pri = new int[K];
		time = new int[K];
		for(int k = 0 ; k < K ; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			pri[k] = i;
			time[k] = t;
		}

		for(int i = 0 ; i <= N ; i++) {
			if(i - time[0] < 0) continue;
			dp[0][i] = pri[0];
		}


		for(int i = 1 ; i < K ; i++) {
			for(int j = 0 ; j <= N ; j++) {
				if(j-time[i] < 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]]+pri[i]);
			}
		}
		
//		for(int i = 0 ; i < K ; i++) {
//			for(int j = 0 ; j <= N ; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		long res = 0L;
		for(int j = 0 ; j <= N ; j++) {
			res = Math.max(res, dp[K-1][j]);
		}
		System.out.println(res);
	}
}
