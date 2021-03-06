import java.io.*;
import java.util.*;

public class _boj_11722 {
	static int N;
	static int arr[];
	static int dp[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int MAX = 1;
		for(int i = N-1 ; i > 0 ; i--) {
			if(dp[i] == 0) dp[i] = 1;
			for(int j = i-1 ; j >= 0 ; j--) {
				if(arr[i] < arr[j]) {
					if(dp[j] < dp[i] + 1) {
						dp[j] = dp[i]+1;
						MAX = Math.max(MAX, dp[j]);
					}
				}
			}
		}
		System.out.println(MAX);
	}
}