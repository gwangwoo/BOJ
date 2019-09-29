import java.io.*;
import java.util.*;

public class _boj_16929_TwoDots {
	static int N,M;
	static char map[][];
	static int visited[][];
	static int or,oc;
	static boolean check[] = new boolean[28];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};

	static void dfs(int r,int c,int cnt) {
		if(cnt >= 4 && or == r && oc == c) {
			System.out.println("Yes");
			System.exit(0);
		}
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] == 1 ||map[nr][nc] != map[r][c]) continue;
			visited[nr][nc] = 1;
			dfs(nr,nc,cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(visited[i], -1);
		}
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// dfs 돌려보기.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(check[map[i][j]-'A']) continue;
				check[map[i][j]-'A'] = true;
				or = i; oc = j;
				visited[i][j] = 0;
				dfs(i,j,0);
				for(int k = 0; k < N ; k++) {
					Arrays.fill(visited[k], -1);
				}
				check[map[i][j] -'A'] = false;
			}
		}
		System.out.println("No");
	}

}
