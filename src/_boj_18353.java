import java.io.*;
import java.util.*;
public class _boj_18353 {
	static int N;
	static int arr[];
	static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 1;
		for(int i = 0 ; i < N-1 ; i++) {
			if(dp[i] == 0 ) dp[i] = 1;
			for(int j = i+1 ; j < N ; j++) {
				if(arr[i] > arr[j]) {
					if(dp[j] < dp[i]+1) {
						dp[j] = dp[i] + 1;
						max = Math.max(dp[j], max);
					}
				}
			}
		}
		System.out.println(N-max);
	}
}
