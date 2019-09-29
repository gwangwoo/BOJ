import java.io.*;
import java.util.*;

public class _boj_1629_곱셈 {
	static long mul(long a, long b, long c) {
		if (b == 0) {
			return 1;
		}

		long n = mul(a, b / 2, c);
		long temp = n * n % c;

		if (b % 2 == 0) {
			return temp;
		} else {
			return a * temp % c;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		long val = mul(A,B,C);
		System.out.println(val);

	}

}
