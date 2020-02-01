import java.io.*;
import java.util.*;
public class _boj_18353_nlogn {
	static int N;
	static int dp[];
	static int arr[];
	
	static int lower_bound(int left, int right,int key) {
		int res = 0;
		while(left <= right) {
			int mid = (left+right) >> 1;
			if(arr[key] < dp[mid]) left = mid+1;
			else {
				res = mid;
				right = mid-1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = arr[0];
		int idx = 0;
		for(int i = 1 ; i < N ; i++) {
			if(arr[i] < dp[idx]) {
				dp[++idx] = arr[i];
			}else {
				int ii = lower_bound(0,idx,i);
				dp[ii] = arr[i];
			}
		}
		System.out.println(N-(idx+1));
	}
}