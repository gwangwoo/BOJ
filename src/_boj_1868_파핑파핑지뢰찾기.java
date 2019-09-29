import java.io.*;
import java.util.*;

public class _boj_1868_파핑파핑지뢰찾기 {
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	static int N;
	static ArrayList<Point> astr;
	static char map[][];
	static int value[][];
	static boolean visited[][];

	static int bfs(int r,int c) {
		Queue<Point> q = new LinkedList<>();
		visited[r][c] = true;
		map[r][c] = '0';
		q.add(new Point(r,c));
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r; c = p.c;

			for(int k = 0 ; k < 8 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;

				if(value[nr][nc] == 0) {
					q.add(new Point(nr,nc));
					visited[nr][nc] = true;
					map[nr][nc] = (char)(value[nr][nc]+'0');
				}else if(value[nr][nc] != 0 && value[nr][nc] != -1) {
					visited[nr][nc] = true;
					map[nr][nc] = (char)(value[nr][nc]+'0');
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			value = new int[N][N];
			astr = new ArrayList<>();
			for(int i = 0 ; i < N ; i++) {
				String str = br.readLine();
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') {
						astr.add(new Point(i,j));
						value[i][j] = -1;
					}

				}
			}
			for(int i = 0 ; i < astr.size() ; i++) {
				Point now = astr.get(i);
				for(int k = 0 ; k < 8 ; k++) {
					int nr = now.r + dr[k];
					int nc = now.c + dc[k];
					if(nr <  0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == '*') continue;
					value[nr][nc]+=1;
				}
			}
			
			visited = new boolean[N][N];
			int res = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(value[i][j] == 0 && !visited[i][j]) {
						res += bfs(i,j);
					}
				}
			}
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(value[i][j] != 0  && value[i][j] != -1 && !visited[i][j]) res+=1;
				}
			}
			System.out.println("#"+tc + " " + res);

		}
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
