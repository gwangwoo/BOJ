import java.io.*;
import java.util.*;

public class _boj_16988_Baaaaaaaaaduk2 {
	static int N,M;
	static int map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static ArrayList<Point> cand;
	
	static int bfs(boolean check[][], int r, int c) {
		int cnt = 0;
		check[r][c] = true;
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> target = new ArrayList<>();
		q.add(new Point(r,c));
		target.add(new Point(r,c));
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r;
			c = p.c;
			
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || check[nr][nc] || map[nr][nc] != 2) continue;
				q.add(new Point(nr,nc));
				check[nr][nc] = true;
				target.add(new Point(nr,nc));
			}
		}
		
		for(int i = 0 ; i < target.size() ; i++) {
			Point now = target.get(i);
			for(int k = 0 ; k < 4 ; k++) {
				int nr = now.r + dr[k];
				int nc = now.c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(map[nr][nc] == 0) return 0;
			}
			cnt++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cand = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					cand.add(new Point(i,j));
				}
			}
		}
		int res = 0;
		boolean check[][] = new boolean[N][M];
			for(int i = 0 ; i < cand.size() ; i++) {
			map[cand.get(i).r][cand.get(i).c] = 1;
			for(int j = 0 ; j < cand.size() ; j++) {
				if(i == j) continue;
				map[cand.get(j).r][cand.get(j).c] = 1;
				for(int x = 0 ; x < N ; x++) Arrays.fill(check[x], false);
				int val = 0;
				for(int r = 0 ; r < N ; r++) {
					for(int c = 0 ; c < M ; c++) {
						if(!check[r][c] && map[r][c] == 2) {
							val +=  bfs(check,r,c);
						}
					}
				}
				res = Math.max(val, res);
				map[cand.get(j).r][cand.get(j).c] = 0;
			}
			map[cand.get(i).r][cand.get(i).c] = 0;
		}
		System.out.println(res);
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r =r;
			this.c = c;
		}
	}
}
