import java.io.*;
import java.util.*;

public class _boj_2631 {
	static int dp[];
	static int arr[];
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} 
		for(int i = 0; i < N-1 ; i++) {
			if(dp[i] == 0) dp[i] = 1;
			for(int j = i+1 ; j < N ; j++) {
				if(arr[j] > arr[i]) dp[j] = Math.max(dp[j], dp[i]+1);
			}
		}
		int res = 0;
		for(int i = 0 ; i < N ; i++) res = Math.max(res, dp[i]);
		System.out.println(N-res);
	}
}
