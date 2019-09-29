import java.io.*;
import java.util.*;

public class _boj_1194_달이차오른다가자 {
	static int N,M,res;
	static Point start;
	static char map[][];
	static int check[][][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
	static void bfs(Point s) {
		check = new int[N][M][1<<6];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(s.r,s.c,0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			int k = p.k;
			
			if(map[r][c] == '1') {
				res = check[r][c][k];
				return;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#' 
						|| check[nr][nc][k] != 0) continue;
				
				if('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
					int nk = k | (1 << (map[nr][nc]-'a'));
					if(check[nr][nc][nk] == 0) {
						check[nr][nc][nk] = check[r][c][k] + 1;
						q.add(new Point(nr,nc,nk));
					}
				}else if('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
					int nk = k & (1 << (map[nr][nc]-'A'));
					if(nk != 0) {
						check[nr][nc][k] = check[r][c][k] +1;
						q.add(new Point(nr,nc,k));
					}
				}else if(check[nr][nc][k] == 0) {
					check[nr][nc][k] = check[r][c][k] + 1;
					q.add(new Point(nr,nc,k));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					start = new Point(i,j,0);
				}
			}
		}
		res = -1;
		bfs(start);
		System.out.println(res);
		
	}
	static class Point {
		int r,c,k;
		Point(int r,int c,int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}

}
