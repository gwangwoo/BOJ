import java.io.*;
import java.util.*;

public class _boj_12015 {
	static int N;
	static int dp[];
	static int arr[];

	static int lower_Bound(int left, int right, int key) {
		int mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			if(dp[mid] < key) left = mid+1;
			else right = mid-1;
		}
		return right+1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		dp[0] = arr[0];
		int idx = 0;
		for(int i =1 ; i < N ; i++) {
			if(arr[i] > dp[idx]) {
				dp[++idx] = arr[i];
			}else {
				int ii = lower_Bound(0,idx,arr[i]);
				dp[ii] = arr[i];
			}
		}
		System.out.println(idx+1);
	}

}
