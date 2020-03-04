import java.io.*;
import java.util.*;

public class _boj_3187 {
	static int N,M;
	static char map[][];
	static boolean visited[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int K,V;
	
	static void bfs(int r,int c) {
		visited[r][c] = true;
		int V_cnt = 0, K_cnt = 0;
		if(map[r][c] == 'v') V_cnt++;
		else K_cnt++;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r;
			c = p.c;
			
			for(int k = 0 ; k <4 ; k++) { 
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#' || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				if(map[nr][nc] == 'k') K_cnt++;
				else if(map[nr][nc] == 'v') V_cnt++;
				q.add(new Point(nr,nc));
			}
		}
		if(K_cnt > V_cnt) {
			K += K_cnt;
		}else V += V_cnt;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0 ; i < N  ;i++) {
			for(int j = 0 ; j <M ; j++) {
				if(visited[i][j]) continue;
				if(map[i][j] == 'v' || map[i][j] == 'k') {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(K + " " + V);
	}
	
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}
