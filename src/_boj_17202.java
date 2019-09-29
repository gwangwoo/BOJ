import java.io.*;
import java.util.*;

public class _boj_17202 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		String str = "";
		for(int i = 0 ; i < 8 ; i++) {
			str += A.charAt(i);
			str += B.charAt(i);
		}
		while(str.length() != 2) {
			int N = str.length();
			String tmp = "";
			for(int i = 0 ; i < N-1 ; i++) {
				tmp = tmp + (((str.charAt(i)-'0') + (str.charAt(i+1)-'0'))%10);
			}
			str = tmp;
		}
		System.out.println(str);
	}
}
