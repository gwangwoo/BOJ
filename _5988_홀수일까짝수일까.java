import java.io.*;
import java.math.*;
public class _5988_홀수일까짝수일까 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- >0) {
			BigInteger N = new BigInteger(br.readLine());
			BigInteger M = new BigInteger("2");
			if(N.mod(M).toString().equals("1")) System.out.println("odd");
			else System.out.println("even");
		}
	}
}
