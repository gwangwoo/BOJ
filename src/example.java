import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class example {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			BigInteger ba = new BigInteger(A);
			BigInteger bb = new BigInteger(B);
			System.out.println(ba.mod(bb));
		}
	}
}
