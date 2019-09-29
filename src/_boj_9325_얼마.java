import java.io.*;
import java.util.*;

public class _boj_9325_얼마 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int val = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				System.out.println(val);
				continue;
			}
			while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				val += a*b;
			}
			System.out.println(val);
		}
		
	}

}
