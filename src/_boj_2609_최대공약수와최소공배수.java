import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class _boj_2609_최대공약수와최소공배수 {
	static int GCD(int a,int b) {
		if(b == 0) return a;
		if(b > a) return GCD(b,a);
		return GCD(b,a%b);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A,B;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int gcd = GCD(A,B);
		int lcm = A/gcd * B/gcd * gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}
}
