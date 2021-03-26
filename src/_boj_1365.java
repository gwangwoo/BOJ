import java.io.*;
import java.util.*;

public class _boj_1365 {
	static int N;
	static int arr[];
	static int brr[];
	static int dp[];
	
	static int lowerBound(int target, int idx) {
		int left = 0;
		int right = idx+1;
		int ret = -1;
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(dp[mid] < target) {
				left = mid+1;
			}else {
				ret = mid;
				right = mid-1;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		// 정방향
		int idx = 0;
		dp[0] = arr[0];
		for(int i = 1 ; i < N ; i++) {
			if(dp[idx] < arr[i]) dp[++idx] = arr[i];
			else {
				int val = lowerBound(arr[i],idx);
				dp[val] = arr[i];
			}
		}
		System.out.println(N-(idx+1));
	}
}
