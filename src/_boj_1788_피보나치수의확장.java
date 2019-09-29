import java.io.*;
import java.util.*;

public class _boj_1788_피보나치수의확장 {
	static long dp[] = new long[1000001];
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[0] = 0; dp[1] = 1;
		for(int i = 2 ; i <= 1000000 ; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_000;
		}
		N = Integer.parseInt(br.readLine());
		int symbol = N;
		if(symbol > 0) symbol = 1;
		else if(symbol < 0) symbol = -1;
		else symbol = 0;
		boolean isEven = false;
		if(N % 2 == 0 && symbol == -1) isEven = true;
		else if(symbol == 0) symbol = 0;
		else symbol = 1;
		if(isEven) System.out.println(symbol);
		else System.out.println(symbol);
		System.out.println(dp[Math.abs(N)]);
		
	}

}
