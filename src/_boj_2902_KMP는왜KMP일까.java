import java.io.*;
import java.util.*;

public class _boj_2902_KMP는왜KMP일까 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < str.length() ; i++) {
			if('A'<=str.charAt(i) && str.charAt(i) <= 'Z') sb.append(str.charAt(i));
		}
		System.out.println(sb.toString());
		
	}

}
