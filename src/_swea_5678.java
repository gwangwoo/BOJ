import java.io.*;
import java.util.*;
public class _swea_5678 {
	static int isPalin(int index, String str) {
		int val = 1;
		int left = index-1;
		int right = index+1;
		if(left >= 0) {
			if(str.charAt(index) == str.charAt(left)) {
				val++;
				left--;
			}
		}else if(right < str.length()) {
			if(str.charAt(index) == str.charAt(right)) {
				val++;
				right++;
			}
		}
		while(left >= 0 && right < str.length()) {
			if(str.charAt(left) == str.charAt(right)) {val+=2;
			left--;
			right++;
			}else break;
		}
		return val;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			String str = br.readLine();
			int MAX = 1;
			for(int i = 0; i < str.length() ; i++) {
				int val = isPalin(i,str);
				MAX = Math.max(MAX, val);
			}
			System.out.println("#"+tc + " " + MAX);
		}
	}
}