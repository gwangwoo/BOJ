import java.io.*;
import java.util.*;

public class _boj_17070_파이프옮기기1 {
	static int N,res;
	static int gr[] = {0,1};
	static int gc[] = {1,1};
	static int sr[] = {1,1};
	static int sc[] = {0,1};
	static int dr[] = {0,1,1};
	static int dc[] = {1,0,1};
	static int map[][];
	static int visited[][];
	// 0: 가로, 1: 세로, 2: 대각선.
	static void dfs(int r, int c, int statue) {
		if(r == N-1 && c == N-1) {
			res++;
			return;
		}
		switch(statue) {
		case 0:
			int nr = r + gr[0];
			int nc = c + gc[0];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) return;
			if(map[nr][nc] == 1) return;
			dfs(nr,nc,0);
			nr = r + gr[1];
			nc = c + gc[1];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) return;
			if(map[nr][nc] == 1 || map[nr][nc-1] ==1 || map[nr-1][nc] == 1) return;
			dfs(nr,nc,2);
			break;
		case 1:
			nr = r + sr[0];
			nc = c + sc[0];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) return;
			if(map[nr][nc] == 1) return;
			dfs(nr,nc,1);
			nr = r + sr[1];
			nc = c + sc[1];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) return;
			if(map[nr][nc] == 1 || map[nr][nc-1] ==1 || map[nr-1][nc] == 1) return;
			dfs(nr,nc,2);
			break;
		case 2:
			nr = r + dr[0];
			nc = c + dc[0];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(map[nr][nc] == 0) {
					dfs(nr,nc,0);
				}
			}
			nr = r + dr[1];
			nc = c + dc[1];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(map[nr][nc] == 0) {
					dfs(nr,nc,1);
				}
			}
			nr = r + dr[2];
			nc = c + dc[2];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) return;
			if(map[nr][nc] == 1 || map[nr][nc-1] ==1 || map[nr-1][nc] == 1) return;
			dfs(nr,nc,2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j= 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new int[N][N];
		dfs(0,1,0);
		System.out.println(res);

	}
	static class Point {
		int r,c,statue;
		Point(int r,int c,int statue) {
			this.r = r;
			this.c = c;
			this.statue = statue;
		}
	}

}

