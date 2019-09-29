import java.io.*;
import java.util.*;

public class _boj_9086_문자열 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String str = br.readLine();
			System.out.println(str.charAt(0) +""+  str.charAt(str.length()-1));
		}
		
	}

}
