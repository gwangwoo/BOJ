import java.io.*;
import java.util.*;

public class _boj_17201 {
	static int N;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		str = br.readLine();
		boolean flag = false;
		for(int i = 0 ; i < str.length()-1 ; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("No");
		}else System.out.println("Yes");
		
	}

}
