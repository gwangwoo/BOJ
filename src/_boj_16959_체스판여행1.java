import java.util.*;
import java.io.*;

public class _boj_16959_체스판여행1 {
	static int N,sr,sc;
	static int dr[][] = {{-2,-2,-1,1,2,2,1,-1},{-1,-1,1,1},{-1,0,1,0}};
	static int dc[][] = {{-1,1,2,2,1,-1,-2,-2},{-1,1,1,-1},{0,1,0,-1}};
	static int mal[] = {8,4,4};
	static int map[][];
	static boolean visited[][][][];	// 0: 나이트, 1: 비숍, 2: 룩.

	static void bfs(int sr, int sc) {
		visited = new boolean[N][N][3][N*N+2];
		Queue<Point> q = new LinkedList<>();
		for(int i = 0 ; i <= 2 ; i++) {
			q.add(new Point(sr,sc,i,2));
			visited[sr][sc][i][1] = true;
		}
		int time = 0;

		while(!q.isEmpty()) {
			int q_size = q.size();
			while(q_size-- > 0) {
				Point p = q.poll();
				int r = p.r;
				int c = p.c;
				int type = p.type;
				int next = p.next;

				if(next == N*N+1) {
					System.out.println(time);
					System.exit(0);
				}


				for(int k = 0 ; k < mal[type] ; k++) {
					int nr = r + dr[type][k];
					int nc = c + dc[type][k];

					while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
						int target = next + (map[nr][nc] == next ? 1 : 0);

						if(!visited[nr][nc][type][target]) {
							visited[nr][nc][type][target] = true;
							q.add(new Point(nr,nc,type,target));
						}

						nr += dr[type][k]; nc = nc += dc[type][k];
						if(type == 0) break;
					}
				}

				for(int m = 0 ; m < 3 ; m++) {
					if(type == m) continue;
					if(!visited[r][c][(m+1)%3][next]) {
						q.add(new Point(r,c,(m+1)%3,next));
						visited[r][c][(m+1)%3][next] = true;
					}
					if(!visited[r][c][(m+2)%3][next]) {
						q.add(new Point(r,c,(m+2)%3,next));
						visited[r][c][(m+2)%3][next] = true;
					}	
				}
			}
			time++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					sr = i; sc = j;
				}
			}
		}
		bfs(sr,sc);

	}
	static class Point {
		int r,c,type,next;
		Point(int r,int c,int type, int next) {
			this.r = r;
			this.c = c;
			this.type = type;
			this.next = next;
		}
	}
}

