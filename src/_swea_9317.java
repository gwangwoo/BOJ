import java.io.*;
import java.util.*;
public class _swea_9317 {
	static int N;
	
	static int check(String first, String last) {
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			if(first.charAt(i) == last.charAt(i)) res++;
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			String first = br.readLine();
			String last = br.readLine();
			System.out.println("#"+tc + " " + check(first,last));
		}
	}
}
