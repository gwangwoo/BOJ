import java.io.*;
import java.util.*;

public class _boj_16933_벽부수고이동하기3 {
	static int dr[] = {-1,0,1,0,0};
	static int dc[] = {0,1,0,-1,0};
	static int N,M,K;
	static int map[][];
	static int check[][][];

	static void bfs(int r,int c) {
		check = new int[N][M][K+1];
		check[r][c][0] = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c,0));
		boolean flag = false;
		while(!q.isEmpty()) {
			flag = !flag;
			int q_size = q.size();
			if(!flag) {
				while(q_size-- > 0) {
					Point p = q.poll();
					if(p.r == N-1 && p.c == M-1) {
						int res = (int)1e9;
						for(int i = 0 ; i <= K ; i++) {
							if(check[p.r][p.c][i] == 0) continue;
							res = Math.min(check[p.r][p.c][i], res);
						}
						System.out.println(res);
						System.exit(0);
					}
					for(int y = 0 ; y < 5 ; y++) {
						int nr = p.r + dr[y];
						int nc = p.c + dc[y];
						if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
						if(map[nr][nc] != 1 &&check[nr][nc][p.k] == 0) {
							check[nr][nc][p.k] = check[p.r][p.c][p.k] + 1;
							q.add(new Point(nr,nc,p.k));
						}else if(y == 4) {
							check[nr][nc][p.k] = check[p.r][p.c][p.k] + 1;
							q.add(new Point(nr,nc,p.k));
						}
					}
				}
				continue;
			}
			while(q_size-- > 0) {
				Point p = q.poll();
				r = p.r;
				c = p.c;
				int k = p.k;
				if(r == N-1 && c == M-1) {
					int res = (int)1e9;
					for(int i = 0 ; i <= K ; i++) {
						if(check[r][c][i] == 0) continue;
						res = Math.min(check[r][c][i], res);
					}
					System.out.println(res);
					System.exit(0);
				}
				for(int y = 0 ; y < 4 ; y++) {
					int nr = r + dr[y];
					int nc = c + dc[y];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

					if(map[nr][nc] == 0 && check[nr][nc][k] == 0) {
						q.add(new Point(nr,nc,k));
						check[nr][nc][k] = check[r][c][k] + 1;
					}else if(map[nr][nc] == 1 && k+1 <= K && check[nr][nc][k+1] == 0) {
						q.add(new Point(nr,nc,k+1));
						check[nr][nc][k+1] = check[r][c][k] + 1;
					}
				}
			}
		}
	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}

		bfs(0,0);
		System.out.println(-1);
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

