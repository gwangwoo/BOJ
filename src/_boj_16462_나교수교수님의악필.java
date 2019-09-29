import java.io.*;
import java.util.*;

public class _boj_16462_나교수교수님의악필 {
	static int N;
	
	static int f(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) == '0' || str.charAt(i) == '6') {
				sb.append("9");
			}else {
				sb.append(str.charAt(i));
			}
		}
		int val = Integer.parseInt(sb.toString());
		if(val > 100) val = 100;
		return val;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		double sum = 0;
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			sum += (double)f(str);
		}
		System.out.println((int)Math.round(sum/(N*1d)));
	}

}
