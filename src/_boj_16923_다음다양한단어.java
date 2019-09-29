import java.io.*;
import java.util.*;

public class _boj_16923_다음다양한단어 {

	public static void main(String[] args) throws IOException{
		boolean check[] = new boolean[26];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		for(int i = 0 ; i < str.length() ; i++) {
			check[str.charAt(i)-'a'] = true;
		}
		StringBuilder sb = new StringBuilder(str);
		boolean flag = false;
		for(int i = 0 ; i < 26 ; i++) {
			if(check[i]) continue;
			else {
				flag = true;
				sb.append((char)('a'+i));
				break;
			}
		}
		if(flag) {
			System.out.println(sb.toString());
		}else {
			while(true) {
				boolean fflag = false;
				int start = sb.charAt(sb.length()-1)-'a';
				for(int i = start ; i < 26 ; i++) {
					if(!check[i]) {
						fflag = true;
						sb.deleteCharAt(sb.length()-1);
						sb.append((char)('a'+ i));
						break;
					}
				}
				if(fflag) {
					System.out.println(sb.toString());
					break;
				}else {
					check[start] = false;
					sb.deleteCharAt(sb.length()-1);
				}
				if(sb.length() == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
	}
}
