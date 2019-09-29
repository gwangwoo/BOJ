import java.io.*;
import java.util.*;

public class _boj_1934_최소공배수 {

	static int GCD(int a,int b) {
		if(b > a) return GCD(b,a);
		if(b != 0) return GCD(b, a%b);
		else return a;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		while(N-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int gcd = GCD(A,B);
			System.out.println((A/gcd) * (B/gcd) * gcd);
		}
		
	}

}
