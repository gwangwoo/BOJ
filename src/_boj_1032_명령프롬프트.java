import java.io.*;
import java.util.*;

public class _boj_1032_명령프롬프트 {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(br.readLine());
		if(N == 1) {
			System.out.println(sb.toString());
			return;
		}
		StringBuilder target = new StringBuilder(br.readLine());
		int length = sb.length();
		boolean check[] = new boolean[length];
		for(int i = 0 ; i < length; i++) {
			if(sb.charAt(i) == target.charAt(i)) {
				check[i] = true;
			}else {
				check[i] = false;
			}
		}
		N-=2;
		while(N-- > 0) {
			target = new StringBuilder(br.readLine());
			for(int i = 0 ; i < length; i++) {
				if(sb.charAt(i) == target.charAt(i) && check[i]) {
					check[i] = true;
				}else {
					check[i] = false;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		for(int i = 0 ; i < length ; i++) {
			if(check[i]) {
				res.append(sb.charAt(i));
			}else res.append("?");
		}
		System.out.println(res.toString());
		
	}

}
