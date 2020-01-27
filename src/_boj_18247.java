import java.io.*;
import java.util.*;
public class _boj_18247 {
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N < 12 || M < 4) {
				System.out.println(-1);
				continue;
			}
			int res = 12 * M - (M-4);
			System.out.println(res);
		}
	}
}