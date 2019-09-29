import java.io.*;
import java.util.*;

public class _boj_10711_모래성 {
	static int H,W,res;
	static char map[][];
	static int adj[][];
	static int visited[][];
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> nq = new LinkedList<>();


	static void getAdj() {
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < W ; j++) {
				if(map[i][j] != '.') {
					for(int k = 0 ; k < 8 ; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];

						if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;

						if(map[nr][nc] == '.') adj[i][j]++;
					}
					if(map[i][j]-'0' <= adj[i][j]) {
						q.add(new Point(i,j));
						visited[i][j] = 0;
					}
				}
			}
		}
	}

	static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;

			// 모래성을 부순다.
			map[r][c] = '.';
			adj[r][c] = 0;

			for(int k = 0 ; k < 8 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];

				if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
				// 근처 모래성에 영향을 끼친다.
				if(map[nr][nc] != '.' && visited[nr][nc] == 1) {
					adj[nr][nc]++;

					if((map[nr][nc]-'0') <= adj[nr][nc]) {
						nq.add(new Point(nr,nc));
						visited[nr][nc] = 0;
					}
				}
			}
			for(int i = 0 ; i < H ; i++) {
				for(int j = 0 ; j < W ; j++) {
					System.out.print(visited[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			if(q.isEmpty()) {
				q.addAll(nq);
				nq.clear();
				res++;
			}
		}

	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visited = new int[H][W];
		adj = new int[H][W];
		for(int i = 0 ; i < H ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < W ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] != '.') visited[i][j] = 1;
			}
		}
		res = 0;
		getAdj();
		bfs();
		System.out.println(res);
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
