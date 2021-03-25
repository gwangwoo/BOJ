import java.io.*;
import java.util.*;
public class _boj_2579_계단오르기 {
	static int N;
	static int dp[];
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		arr = new int[N+1];
		for(int i = 1 ; i <= N ; i++) arr[i] = Integer.parseInt(br.readLine());

		if(N >= 1) {
			dp[1] = arr[1];
		}
		if(N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		if(N >= 3) {
			for(int i = 3 ; i <= N ; i++) {
				dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
			}
		}
		System.out.println(dp[N]);
	}
}
