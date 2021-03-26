import java.io.*;
import java.util.*;
public class _boj_2352 {
	
	static int dp[];
	static int arr[];
	static int N;

	static int lowerBound(int target, int idx) {
		int left = 0;
		int right = idx;
		int ret = -1;
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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new int[N];
		arr = new int[N];
		for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken())+1_000_000_000;
		
		dp[0] = arr[0];
		int idx = 0;
		for(int i = 1 ; i < N ; i++) {
			if(dp[idx] < arr[i]) {
				dp[++idx] = arr[i];
			}else {
				int val = lowerBound(arr[i], idx);
				dp[val] = arr[i];
			}
		}
		System.out.println(idx+1);
		
	}

}
