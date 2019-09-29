import java.io.*;
import java.math.*;
import java.util.*;
public class _10827_ab {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigDecimal a;
		int b;
		a = new BigDecimal(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		System.out.println(a.pow(b).toPlainString());
		
	}

}
