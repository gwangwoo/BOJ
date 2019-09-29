import java.io.*;
import java.util.*;
public class _boj_13900 {
	static int N;
	static int arr[] = new int[10001];
	static long dp[][] = new long[100001][3];
	
	static void init() {
		for(int i = 1 ; i <= 100000 ; i++) {
			for(int j = 1 ; j <= 2 ; j++) {
				if(j == 1) dp[i][j] = i;
				else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int val = Integer.parseInt(st.nextToken());
			arr[val]++;
		}
		long res = 0;
		for(int i = 1 ; i < 10001 ; i++) {
			if(arr[i] == 0) continue;
			for(int j = i ; j < 10001 ; j++) {
				if(arr[j] == 0) continue;
				if(i == j && arr[j] == 1) continue;
				long val = i*j;
				if(i == j) {
					res += val*dp[arr[i]][2];
				}
				else {
					res += arr[i]*arr[j]*val;
				}
			}
		}
		System.out.println(res);
	}
}