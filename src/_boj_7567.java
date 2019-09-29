import java.io.*;
import java.util.*;

public class _boj_7567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int res = 10;
		int l = str.length();
		for(int i = 1 ; i < l ; i++) {
			if(str.charAt(i) == str.charAt(i-1)) res+=5;
			else res+=10;
		}
		System.out.println(res);
	}

}
