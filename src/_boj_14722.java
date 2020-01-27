import java.io.*;
import java.util.*;

public class _boj_14722 {
	static int dr[] = {1,0};
	static int dc[] = {0,1};
	static int N;
	static int map[][];
	static int val[][];
	static int bfs() {
		Queue<Point> q = new LinkedList<>();
		if(map[0][0] == 0) {
			q.add(new Point(0,0,0,1));
			val[0][0] = 1;
		}
		else q.add(new Point(0,0,map[0][0],0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			int statue = p.statue;
			int cnt = p.cnt;
			
			for(int k = 0 ; k < 2 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(statue == 0 && map[nr][nc] == 1 && val[nr][nc] < cnt+1) {
					q.add(new Point(nr,nc,1,cnt+1));
					val[nr][nc] = Math.max(val[nr][nc], cnt+1);
				}else if(statue == 1 && map[nr][nc] == 2 && val[nr][nc] < cnt+1) {
					q.add(new Point(nr,nc,2,cnt+1));
					val[nr][nc] = Math.max(val[nr][nc], cnt+1);
				}else if(statue == 2 && map[nr][nc] == 0 && val[nr][nc] < cnt+1) {
					q.add(new Point(nr,nc,0,cnt+1));
					val[nr][nc] = Math.max(val[nr][nc], cnt+1);
				}else {
					q.add(new Point(nr,nc,statue,cnt));
					val[nr][nc] = Math.max(val[nr][nc], cnt);
				}
			}
		}
		return val[N-1][N-1];
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		val = new int[N][N];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}
	static class Point {
		int r,c,statue,cnt;
		Point(int r,int c,int statue,int cnt) {
			this.r = r;
			this.c = c;
			this.statue = statue;
			this.cnt = cnt;
		}
	}
}
