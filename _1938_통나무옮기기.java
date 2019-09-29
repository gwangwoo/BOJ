import java.util.*;

public class _1938_통나무옮기기 {
	static int N;
	static final int dr[] = {-1,0,1,0};
	static final int dc[] = {0,1,0,-1};
	static char tmp[][];
	static int map[][];
	static Point start;
	static Point end;
	static int res;
	
	static void bfs(Point p) {
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		boolean visited[][][] = new boolean[2][N][N];
		while(!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			int dir = now.dir;
			int count = now.count;
			
			if(r == end.r && c == end.c && dir == end.dir) {
				res = count;
				return;
			}
			if(visited[dir][r][c]) continue;
			visited[dir][r][c] = true;
			
			if(dir == 0) {
				// 상
				if(r-2 >= 0 && map[r-2][c] == 0) {
					q.add(new Point(r-1,c,dir,count+1));
				}
				// 하
				if(r+2 < N && map[r+2][c] == 0) {
					q.add(new Point(r+1,c,dir,count+1));
				}
				// 좌
				if(c-1 >= 0 && map[r-1][c-1] == 0 && map[r][c-1] == 0 && map[r+1][c-1] == 0) {
					q.add(new Point(r,c-1,dir,count+1));
				}
				// 우
				if(c+1 < N && map[r-1][c+1] == 0 && map[r][c+1] == 0 && map[r+1][c+1] == 0) {
					q.add(new Point(r,c+1,dir,count+1));
				}
				// 회전
				if(c-1 >= 0 && c+1 < N && map[r-1][c-1] == 0 && map[r-1][c+1] == 0 && map[r][c-1] == 0 &&
						map[r][c+1] == 0 && map[r+1][c-1] == 0 && map[r+1][c+1] == 0) {
					q.add(new Point(r,c,1,count+1));
				}
			}else {
				// 상
				if(r-1 >= 0 && map[r-1][c-1] == 0 && map[r-1][c] == 0 && map[r-1][c+1] == 0) {
					q.add(new Point(r-1,c,dir,count+1));
				}
				// 하
				if(r+1 < N && map[r+1][c-1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0) {
					q.add(new Point(r+1,c,dir,count+1));
				}
				// 좌
				if(c-2 >= 0 && map[r][c-2] == 0) {
					q.add(new Point(r,c-1,dir,count+1));
				}
				// 우
				if(c+2 < N && map[r][c+2] == 0) {
					q.add(new Point(r,c+1,dir,count+1));
				}
				// 회전
				if(r-1 >= 0 && r+1 < N && map[r-1][c-1] == 0 && map[r-1][c] == 0 && map[r-1][c+1] == 0 &&
						map[r+1][c-1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0) {
					q.add(new Point(r,c,0,count+1));
				}
			}
		}
	}
	
	static void findStart(int r,int c) { 
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(tmp[nr][nc] == 'B') {
				if(dr[k] == 1 || dr[k] == -1) {
					start = new Point(nr,nc,0,0);
				}else {
					start = new Point(nr,nc,1,0);
				}
			}
		}
	}
	
	static void findEnd(int r,int c) {
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(tmp[nr][nc] == 'E') {
				if(dr[k] == 1 || dr[k] == -1) {
					end = new Point(nr,nc,0,0);
				}else {
					end = new Point(nr,nc,1,0);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		res = 0;
		tmp = new char[N][N];
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			String str = sc.next();
			for(int j = 0 ; j < N ; j++) {
				tmp[i][j] = str.charAt(j);
			}
		}
		
		boolean start_flag = false;
		boolean end_flag = false;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				char now = tmp[i][j];
				if(now == 'B') {
					if(start_flag == false) {
						findStart(i,j);
						start_flag = true;
					}
					map[i][j] = 0;
				}else if(now == 'E') {
					if(end_flag == false) {
						findEnd(i,j);
						end_flag = true;
					}
					map[i][j] = 0;
				}else if(now == '1') {
					map[i][j] = 1;
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		bfs(start);
		System.out.println(res);
		
	}
	static class Point {
		int r,c,dir,count;
		Point(int r,int c,int dir,int count) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.count = count;
		}
	}
}
