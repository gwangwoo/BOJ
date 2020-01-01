import java.io.*;
import java.util.*;
public class _boj_18224 {
	static int N,M;
	static int map[][];
	static int visited[][][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};

	static int isPossible(int r,int c,int k) {
		int nr = r + dr[k];
		int nc = c + dc[k];
		int res = 1;
		while(true) {
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) return -1;
			if(map[nr][nc] == 0) return res;
			else {
				nr += dr[k];
				nc += dc[k];
				res++;
			}
		}
	}

	static String bfs(int sr,int sc) {
		String res = "-1";
		int time = M;
		for(int k = 0 ; k < 4 ; k++) visited[sr][sc][k] = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr,sc));
		int day = 0;
		String now = "sun";
		while(!q.isEmpty()) {
			day++;
			// 낮
			now = "sun";
			time = M;
			while(time-- > 0) {
				int q_size = q.size();
				while(q_size-- > 0) {
					Point p = q.poll();
					int r = p.r;
					int c = p.c;
					if(r == N-1 && c == N-1) {
						return day + " " + now;
					}
					
					for(int k = 0 ; k < 4 ; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc][k] != 0 || map[nr][nc] == 1) continue;
						q.add(new Point(nr,nc));
						visited[nr][nc][k] = visited[r][c][k] + 1;
					}
				}
			}
			// 밤.
			now = "moon";
			time = M;
			while(time-- > 0) {
				int q_size = q.size();
				while(q_size-- > 0) {
					Point p = q.poll();
					int r = p.r;
					int c = p.c;
					if(r == N-1 && c == N-1) {
						return day + " " + now;
					}
					for(int k = 0 ; k < 4 ; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc][k] != 0) continue;
						if(map[nr][nc] == 0) {
							q.add(new Point(nr,nc));
							visited[nr][nc][k] = visited[r][c][k] + 1;
						}else {
							int val = 0;
							if((val = isPossible(nr,nc,k)) > 0) {
								nr += dr[k]*val;
								nc += dc[k]*val;
								if(visited[nr][nc][k] != 0) continue;
								q.add(new Point(nr,nc));
								visited[nr][nc][k] = visited[r][c][k] + 1;
							}
						}
					}
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new int[N][N][4];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs(0,0));
	}	
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
