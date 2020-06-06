import java.io.*;
import java.util.*;
public class _boj_14430 {
	static int N,M;
	static int map[][];
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = map[i][j];
				}else if(i == 0) {
					dp[i][j] = dp[i][j-1] + map[i][j];
				}else if(j == 0) {
					dp[i][j] = dp[i-1][j] + map[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
				}
			}
		}
		System.out.println(dp[N-1][M-1]);
	}

}
