import java.io.*;
import java.util.*;

public class _boj_1932_정수삼각형 {
	static int N;
	static int map[][];
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <= i ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i++) dp[N-1][i] = map[N-1][i];
		
		for(int i = N-2 ; i >= 0 ; i--) {
			for(int j = 0 ; j <= i; j++) {
				dp[i][j] = map[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		System.out.println(dp[0][0]);
	}
}
