import java.io.*;
import java.util.*;

public class _boj_17175 {
	static long dp[] = new long[101];
	static long cnt[] = new long[101];
	static long res;
	static long fibonacci(int n) { // 호출
		if(n < 2) {
			return n;
		}
		else {
			if(dp[n] > 0) {
				return dp[n];
			}
			dp[n] = fibonacci(n-2) + fibonacci(n-1);
			cnt[n] = (cnt[n-2] + cnt[n-1] + 1) % 1_000_000_007;
			return dp[n];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cnt[1] = cnt[0] = 1;
		fibonacci(N);
		res += cnt[N];
		System.out.println(res);

	}

}
