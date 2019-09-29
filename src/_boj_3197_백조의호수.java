import java.util.*;
import java.io.*;

public class _boj_3197_백조의호수 {
	static char map[][];
	static int imap[][];
	static int N,M;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static Queue<Point> q;
	static ArrayList<Point> arr;

	static int day_cnt() {
		int day = 0;
		int check[][] = new int[N][M];
		while(!q.isEmpty()) {
			int q_size = q.size();
			while(q_size-- >0) {
				Point p = q.poll();
				int r = p.r;
				int c = p.c;

				for(int k = 0 ; k < 4 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(map[nr][nc] == 'X' && check[nr][nc] == 0) {
						imap[nr][nc] = imap[r][c] + 1;
						check[nr][nc] = 1;
						q.add(new Point(nr,nc));
					}
				}
			}
			day++;
		}

		return day-1;
	}

	static boolean isMeet(Point p, int d) {
		int check[][] = new int[N][M];
		Queue<Point> Q = new LinkedList<>();
		Q.add(p);
		check[p.r][p.c] = 1;
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			int r = now.r;
			int c = now.c;

			if(r == arr.get(1).r && c == arr.get(1).c) {
				return true;
			}

			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || check[nr][nc] == 1) continue;
				if(imap[nr][nc] <= d) {
					Q.add(new Point(nr,nc));
					check[nr][nc] = 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q = new LinkedList<>();
		arr = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		imap = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'L') {
					arr.add(new Point(i,j));
					map[i][j] = '.';
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(j != 0 && map[i][j] == 'X' && map[i][j-1] == '.') {
					q.add(new Point(i,j-1));
				}else if(j != 0 && map[i][j] == '.' && map[i][j-1] == 'X') {
					q.add(new Point(i,j));
				}
			}
		}

		int time = 0;
		int left,right;
		left = 0;
		right = day_cnt();
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(isMeet(arr.get(0), mid)) right = mid -1;
			else left = mid + 1;
		}
		System.out.println(left);
	}
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
