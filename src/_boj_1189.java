import java.io.*;
import java.util.*;

public class _boj_1189 {
	static int R,C,K;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static char map[][];
	static boolean visited[][];
	
	static int dfs(int r,int c,int cnt) {
		int ret = 0;
		if(r == 0 && c == C-1 && cnt == K) return 1;
		
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 'T') continue;
			visited[nr][nc] = true;
			ret += dfs(nr,nc,cnt+1);
			visited[nr][nc] = false;
		}
		return ret;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visited[R-1][0] = true;
		System.out.println(dfs(R-1,0,1));
		
	}
	static class Point {
		int r,c,cnt;
		Point(int r,int c,int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
