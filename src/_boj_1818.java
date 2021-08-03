import java.io.*;
import java.util.*;

public class _boj_1818 {
	
	static int lowerBound(int dp[], int target, int idx) {
		int left = 1;
		int right = idx;
		int ret = 0;
		while(left <= right) {
			int mid = (left+ right) >> 1;
			if(dp[mid] < target) left = mid+1;
			else {
				right = mid-1;
				ret = mid;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		int dp[] = new int[N+1];
		for(int i = 1; i <= N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		dp[1] = arr[1];
		int idx = 1;
		for(int i = 2; i<= N ; i++) {
			if(arr[i] > dp[idx]) dp[++idx] = arr[i];
			else {
				int val = lowerBound(dp, arr[i], idx);
				dp[val] = arr[i];
			}
		} 
		System.out.println(N-idx);
	}
}
