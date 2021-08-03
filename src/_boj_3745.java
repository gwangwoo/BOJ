import java.io.*;
import java.util.*;

public class _boj_3745 {
	
	static int lowerBound(int dp[], int target, int idx) {
		int left = 0;
		int right = idx;
		int ret = 0;
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(dp[mid] < target) {
				left = mid+1;
			}else {
				right = mid-1;
				ret = mid;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		while((input = br.readLine()) != null) {
			int N = Integer.parseInt(input.trim());
			int arr[] = new int[N+1];
			int dp[] = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int i = 1 ; i <= N ; i++) arr[i] = Integer.parseInt(st.nextToken());
			dp[1] = arr[1];
			int idx = 1;
			for(int i = 2 ; i <= N ; i++) {
				if(arr[i] > dp[idx]) {
					dp[++idx] = arr[i];
				}else {
					int val = lowerBound(dp,arr[i], idx);
					dp[val] = arr[i];
				}
			}
			
			System.out.println(idx);
		}
	}
}
