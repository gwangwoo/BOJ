import java.io.*;
import java.util.*;
public class _boj_2352 {
	static int N;
	static int arr[];
	static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(dp[i] == 0) dp[i] = arr[i];
			for(int j = i ; j < N ; j++) {
				if(arr[i] < arr[j]) {
					if(dp[j] < dp[i] + 1) {
						dp[j] = dp[i] + 1;
					}
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			System.out.print(dp[i]+ " ");
		}
		
	}

}
