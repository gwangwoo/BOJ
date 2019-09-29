import java.io.*;
import java.util.*;

public class _boj_2999 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.length() <= 3) {
			System.out.println(str);
			return;
		}
		int C = 0;
		int R = (int)Math.sqrt(str.length());
		int tmp = (int)Math.pow(R, 2);
		if(tmp != str.length()) {
//			R--;
			int cnt = R;
			for(int i = 1 ; i <= cnt ; i++) {
				int mok = str.length()/i;
				if(mok * i == str.length()) {
					C = mok;
					R = i;
				}
			}
		}else C = R;
		char map[][] = new char[C][R];
		int idx = 0;
		for(int i = 0 ; i < C ; i++) {
			for(int j = 0 ; j < R ; j++) {
				map[i][j] = str.charAt(idx++);
			}
		}
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				System.out.print(map[j][i]);
			}
		}
		System.out.println();
		
	}
}