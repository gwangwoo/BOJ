import java.io.*;
import java.util.*;

public class _boj_14490 {
	
	static int gcd(int a,int b) {
		if(b > a) return gcd(b,a);
		if(b <= 0) return a;
		return gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),":");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int mod = gcd(a,b);
		
		System.out.println(a/mod + ":" + b/mod);
	}
}
