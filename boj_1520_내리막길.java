import java.util.*;

public class boj_1520_내리막길 {
	static final int dr[] = {-1,0,1,0};
	static final int dc[] = {0,1,0,-1};
	static int N,M;
	static int map[][];
	static int dp[][];
	
	static int dfs(int r,int c) {
		if(r == N-1 && c == M-1) {
			return 1;
		}
		
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		
		dp[r][c] = 0;
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(map[nr][nc] < map[r][c]) {
				dp[r][c] += dfs(nr,nc);
			}
		}
		return dp[r][c];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		dp = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0,0));
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
