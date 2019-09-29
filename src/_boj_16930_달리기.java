import java.util.*;
import java.io.*;

public class _boj_16930_달리기 {
	static char map[][];
	static int N,M,K;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int sr,sc,er,ec;

	static void bfs(int sr,int sc) {
		boolean check[][] = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr,sc,0));
		check[sr][sc] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			int time = p.time;
			// 그 방향으로 최소 1개, 최대 K개의 빈 칸을 이동한다.

			if(r == er && c == ec) {

				System.out.println(time);
				System.exit(0);
			}
			NEXT:
				for(int k = 0 ; k < 4 ; k++) {
					for(int cnt = 1 ; cnt <= K ; cnt++) {
						int nr = r + dr[k]*cnt;
						int nc = c + dc[k]*cnt;
						if(time == 2 && k == 2);
						if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#') continue NEXT;
						if(map[nr][nc] == '.' && !check[nr][nc]) {
							//						System.out.println(time);
							q.add(new Point(nr,nc,time+1));
							check[nr][nc] = true;
						}
					}
				}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken())-1;
		sc = Integer.parseInt(st.nextToken())-1;
		er = Integer.parseInt(st.nextToken())-1;
		ec = Integer.parseInt(st.nextToken())-1;

		bfs(sr,sc);

		System.out.println("-1");

	}
	static class Point {
		int r,c,time;
		Point(int r,int c,int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

}