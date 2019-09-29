import java.io.*;
import java.util.*;

public class _boj_1316_그룹단어체커 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int res = 0;
		NEXT:
		while(T-- > 0) {
			char before = ' ';
			String str = br.readLine();
			boolean check[] = new boolean[26];
			for(int i = 0 ; i < str.length() ; i++) {
				char now = str.charAt(i);
				if(before != now && check[now-'a']) continue NEXT;
				check[now-'a'] = true;
				before = now;
			}
			res++;
		}
		System.out.println(res);
		
	}

}
