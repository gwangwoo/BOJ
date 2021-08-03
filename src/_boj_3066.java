import java.io.*;
import java.util.*;

public class _boj_3066 {
	
	static int lowerBound(int dp[], int target, int idx) {
		int left = 1;
		int right = idx;
		int ret = 0;
		while(left <= right) {
			int mid = (left + right) >> 1;
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
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {	
			int N = Integer.parseInt(br.readLine());
			int dp[] = new int[N+1];
			int arr[] = new int[N+1];
			for(int i = 1 ; i<= N ; i++) arr[i] = Integer.parseInt(br.readLine());
			dp[1] = arr[1];
			int idx = 1;
			for(int i = 2 ; i <= N ; i++) {
				if(dp[idx] < arr[i]) {
					dp[++idx] = arr[i];
				}else {
					int val = lowerBound(dp, arr[i] , idx);
					dp[val] = arr[i];
				}
			}
			System.out.println(idx);
		}
	}
}
