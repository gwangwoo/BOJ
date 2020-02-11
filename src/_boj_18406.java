import java.util.*;
import java.io.*;

public class _boj_18406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int left = 0;
		int right = 0;
		int N = str.length();
		for(int i = 0 ; i < N ; i++) {
			if(i < N/2) left += str.charAt(i)-'0';
			else right += str.charAt(i)-'0';
		}
		if(left == right) System.out.println("LUCKY");
		else System.out.println("READY");
	}
}		
