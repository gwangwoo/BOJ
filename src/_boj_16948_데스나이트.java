import java.io.*;
import java.util.*;

public class _boj_16948_데스나이트 {
	static int dr[] = {-2,-2,0,0,2,2};
	static int dc[] = {-1,1,-2,2,-1,1};
	static int sr,sc,er,ec;
	static int N;
	static int visited[][];
	
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		visited = new int[N][N];
		visited[r][c] = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r; c = p.c;
			
			if(r == er && c == ec) {
				System.out.println(visited[r][c]-1);
				System.exit(0);
			}
			
			for(int k = 0 ; k < 6 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] != 0) continue;
				visited[nr][nc] = visited[r][c] + 1;
				q.add(new Point(nr,nc));
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		er = Integer.parseInt(st.nextToken());
		ec = Integer.parseInt(st.nextToken());
		
		bfs(sr,sc);
		System.out.println(-1);
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
