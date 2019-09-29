import java.io.*;
import java.util.*;

public class _boj_17086_아기상어2 {
	static int N,M;
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	static int map[][];
	static int q[][] = new int[6000][2];
	static int front,rear;
	
	static void bfs() {
		
		while(front < rear) {
			int r = q[front][0];
			int c = q[front++][1];
			
			for(int k = 0 ; k < 8 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 0) continue;
				map[nr][nc] = map[r][c] + 1;
				q[rear][0] = nr;
				q[rear++][1] = nc;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q[rear][0] = i;
					q[rear++][1] = j;
				}
			}
		}
		bfs();
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				res = Math.max(res, map[i][j]);
			}
		}
		System.out.println(res-1);
	}

}
