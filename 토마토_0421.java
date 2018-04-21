import java.util.*;

public class 토마토_0421 {
	static int map[][];
	static int check[][];
	static int dist[][];
	static int N,M;
	static Queue<Point> q = new LinkedList<>();
	static final int dx[] = {-1,0,1,0};
	static final int dy[] = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		check = new int[N][M];
		dist = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					q.add(new Point(i,j));
					check[i][j] = 1;
					map[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int k = 0 ; k < 4 ; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(map[nx][ny] == 0 && check[nx][ny] == 0) {
					check[nx][ny] = 1;
					map[nx][ny] = map[x][y] + 1;
					q.add(new Point(nx,ny));
				}
			}
		}
		int ans = -1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(ans < map[i][j]) ans = map[i][j];
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0 && check[i][j] == 0) {
					ans = -1;
				}
			}
		}
		System.out.println(ans);
		
	}
	static class Point{
		int x,y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
