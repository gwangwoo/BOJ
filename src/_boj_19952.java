import java.io.*;
import java.util.*;

public class _boj_19952 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int W,H,O,F,sr,sc,er,ec;
	static int map[][];
	
	static boolean bfs() {
		boolean visited[][] = new boolean[H][W];
		Queue<Point> q = new LinkedList<>();
		visited[sr][sc] = true;
		q.add(new Point(sr,sc,F));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			int power = p.power;
			
			if(r == er && c == ec) return true;
			if(power <= 0) continue;
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc]) continue;
				if(map[nr][nc] <= map[r][c]) {
					q.add(new Point(nr,nc,power-1));
					visited[nr][nc] = true;
				}else if(map[nr][nc] > map[r][c] && map[nr][nc] - map[r][c] <= power) {
					q.add(new Point(nr,nc,power-1));
					visited[nr][nc] = true;
				}
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			F = Integer.parseInt(st.nextToken());
			sr = Integer.parseInt(st.nextToken())-1;
			sc = Integer.parseInt(st.nextToken())-1;
			er = Integer.parseInt(st.nextToken())-1;
			ec = Integer.parseInt(st.nextToken())-1;
			map = new int[H][W];
			for(int i = 0 ; i < O ; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				int p = Integer.parseInt(st.nextToken());
				map[r][c] = p;
			}
			if(bfs()) System.out.println("잘했어!!");
			else System.out.println("인성 문제있어??");
		}
	}
	static class Point {
		int r,c,power;
		Point(int r,int c,int power) {
			this.r = r;
			this.c = c;
			this.power = power;
		}
	}
}