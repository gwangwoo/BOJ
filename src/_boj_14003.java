import java.io.*;
import java.util.*;

public class _boj_14003 {
	static int N;
	static int arr[];
	static int dp[];
	static Pair lis[];
	
	static int lower_Bound(int left, int right, int key) {
		int mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			if(dp[mid] < key) left = mid+1;
			else right = mid-1;
		}
		return right+1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		lis = new Pair[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken())+1_000_000_000;
		}
		dp[0] = arr[0];
		lis[0] = new Pair(0,arr[0]);
		int idx = 0;
		for(int i = 1; i < N ; i++) {
			if(dp[idx] < arr[i]) {
				dp[++idx] = arr[i];
				
				lis[i] = new Pair(idx,arr[i]);
			}else {
				int val = lower_Bound(0,idx,arr[i]);
				dp[val] = arr[i];
				
				lis[i] = new Pair(val, arr[i]);
			}
		}
		int MAX = idx;
		Stack<Integer> stk = new Stack<>();
		for(int i = N-1 ; i >= 0 ; i--) {
			if(lis[i].first == MAX) {
				stk.add(lis[i].second-1_000_000_000);
				MAX--;
			}
		}
		
		int n = stk.size();
		System.out.println(idx+1);
		for(int i = 0 ; i < n ; i++) {
			System.out.print(stk.pop() + " ");
		}
		
	}
	static class Pair {
		int first,second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
