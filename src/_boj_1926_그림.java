import java.io.*;
import java.util.*;

public class _boj_1926_그림 {
	static int N,M;
	static int map[][];
	static boolean check[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static ArrayList<Point> cand;

	static int bfs(Point now) {
		int res = 1;
		check[now.r][now.c] = true;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(now.r, now.c));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;

			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || check[nr][nc] || map[nr][nc] == 0) continue;
				res++;
				check[nr][nc] = true;
				q.add(new Point(nr,nc));
			}
		}


		return res;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cand = new ArrayList<>();
		map = new int[N][M];
		check = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <  M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cand.add(new Point(i,j));
				}
			}
		}
		int cnt = 0;
		int res = 0;
		for(int i = 0 ; i < cand.size() ; i++) {
			if(check[cand.get(i).r][cand.get(i).c]) continue;
			int val = bfs(cand.get(i));
			res = Math.max(val, res);
			cnt++;
		}
		System.out.println(cnt);
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
