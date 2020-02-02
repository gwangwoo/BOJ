import java.io.*;
import java.util.*;

public class _swea_3820 {
	static int N;
	static Rail arr[];
	static final long MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new Rail[N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Rail(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())); 
			}
			Arrays.parallelSort(arr);
			long res = 1;
			for(int i = 0 ; i < N ; i++) {
				res = (arr[i].a * res) % MOD + arr[i].b % MOD;
				res = res % MOD;
			}
			System.out.println("#"+tc + " " + res);
		}
	}
	static class Rail implements Comparable<Rail>{
		long a,b;
		Rail(long a,long b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Rail target) {
			if(this.b * (target.a - 1) - target.b * (this.a-1) > 0) return 1;
			else if(this.b * (target.a - 1) - target.b * (this.a-1) < 0) return -1;
			return 0;
		}
	}
}
