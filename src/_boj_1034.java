import java.io.*;
import java.util.*;
public class _boj_1034 {
	static int N,M,K;
	static int map[][];
	static String arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		arr = new String[N];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			arr[i] = str;
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		K = Integer.parseInt(br.readLine());
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			int cnt = 0;
			int cnt2 = 0;
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0) cnt++;

			}
			if(cnt <= K) {
				if((cnt % 2 == 0 && K % 2 == 0) || (cnt % 2 == 1 && K % 2 == 1)) {
					for(int k = 0 ; k < N ; k++) {
						if(arr[i].equals(arr[k])) cnt2++;
					}
					res = Math.max(res, cnt2);
				}
			}
		}
		System.out.println(res);


	}
}
