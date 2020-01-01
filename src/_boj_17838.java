import java.io.*;
import java.util.*;
public class _boj_17838 {

	static boolean left(String str) {
		if(str.charAt(0) == str.charAt(1) && str.charAt(0) == str.charAt(4)) return true;
		return false;
	}
	
	static boolean right(String str) {
		if(str.charAt(2) == str.charAt(3) && str.charAt(3) == str.charAt(5) && str.charAt(5) == str.charAt(6)) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			String str = br.readLine();
			// 0 1 4
			if(left(str) && right(str)) {
				if(str.charAt(0) != str.charAt(6)) {
					System.out.println(1);
					continue;
				}
			}
			System.out.println(0);
		}
	}
}