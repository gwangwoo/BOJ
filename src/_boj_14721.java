import java.io.*;
import java.util.*;
public class _boj_14721 {
	static int N;
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0] = x;
			arr[i][1] = y;
		}
		int resA = 0, resB = 0;
		long MIN = Long.MAX_VALUE;
		for(int a = 1; a <= 100 ; a++) {
			for(int b = 1 ; b <= 100 ; b++) {
				long RSS = 0L;
				for(int i = 0; i < N ; i++) {
					RSS += (long)Math.pow((arr[i][1] - (long)(a*arr[i][0]+b)),2);
				}
				if(MIN > RSS) {
					MIN = RSS;
					resA = a;
					resB = b;
				}
			}
		}
		System.out.println(resA + " " + resB);
	}
}
