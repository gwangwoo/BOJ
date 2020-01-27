import java.io.*;
import java.util.*;
public class _boj_14716 {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	
	static void dfs(int r,int c) {
		visited[r][c] = true;
		for(int k = 0 ; k < 8 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
			if(map[nr][nc] == 1) dfs(nr,nc);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j =0  ; j < M ; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					dfs(i,j);
					res++;
				}
			}
		}
		System.out.println(res);
	}

}
