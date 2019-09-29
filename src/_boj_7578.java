import java.io.*;
import java.util.*;
public class _boj_7578 {
	static int N;
	static Pair arr[];
	static int dp[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new Pair[N];
		dp = new int[N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(a,b);
		}
		Arrays.parallelSort(arr);
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			if(dp[i] == 0) dp[i] = 1;
			for(int j = i ; j < N ; j++) {
				if(arr[j].B > arr[i].B) {
					if(dp[j] < dp[i]+1) {
						dp[j] = dp[i] + 1;
						res = Math.max(dp[j], res);
					}
				}
			}
		}
		System.out.println(N-res);
		
	}
	static class Pair implements Comparable<Pair>{
		int A,B;
		Pair(int A,int B) {
			this.A = A;
			this.B = B;
		}
		@Override
		public int compareTo(Pair target) {
			if(this.A < target.A) return -1;
			else if(this.A > target.A) return 1;
			return 0;
		}
	}
}
