import java.io.*;
import java.util.*;
// 
public class _2151_거울설치 {	
	static char[][] map;
	static int startX,startY,endX,endY;
	static int check[][][];
	static final int dx[] = {-1,0,1,0};
	static final int dy[] = {0,1,0,-1};
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		check = new int[N][N][4];
		startX = -1;
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '#') {
					if(startX == -1) {
						startX = i; startY = j;
					}else {
						endX = i; endY = j;
					}
				}
				for(int k = 0 ; k < 4 ; k++) {
					check[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		// * : 벽 , # 입구와 출구 , ! : 거울을 놓을수 있는 자리 , . 움직을수있는자리
		for(int k = 0 ; k < 4 ; k++) {
			check[startX][startY][k] = 0;
			q.add(new Point(startX,startY,k));
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nx = p.x + dx[p.dir];
			int ny = p.y + dy[p.dir];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(map[nx][ny] == '*') continue;

			if(map[nx][ny] == '#') {
				if(check[nx][ny][p.dir] > check[p.x][p.y][p.dir]) {
					check[nx][ny][p.dir] = check[p.x][p.y][p.dir];
					continue;
				}
			}

			if(map[nx][ny] == '.') {
				if(check[nx][ny][p.dir] > check[p.x][p.y][p.dir]) {
					check[nx][ny][p.dir] = check[p.x][p.y][p.dir];
					q.add(new Point(nx,ny,p.dir));
					continue;
				}
			}
			if(map[nx][ny] == '!') {
				// 거울을 설치하는 경우와 하지않는 경우.

				// 거울을 설치하지 않음.
				if(check[nx][ny][p.dir] > check[p.x][p.y][p.dir]) {
					check[nx][ny][p.dir] = check[p.x][p.y][p.dir];
					q.add(new Point(nx,ny,p.dir));
				}
				// 거울을 설치함.
				if(check[nx][ny][(p.dir+1)%4] > check[p.x][p.y][p.dir] +1) {
					check[nx][ny][(p.dir+1)%4] = check[p.x][p.y][p.dir] +1;
					q.add(new Point(nx,ny,(p.dir+1)%4));
				}
				if(check[nx][ny][(p.dir+3)%4] > check[p.x][p.y][p.dir] +1) {
					check[nx][ny][(p.dir+3)%4] = check[p.x][p.y][p.dir] +1;
					q.add(new Point(nx,ny,(p.dir+3)%4));
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < 4 ; i++) {
			if(min > check[endX][endY][i]) {
				min = check[endX][endY][i];
			}
		}
		System.out.println(min);


	}
	static class Point {
		int x,y;
		int count,dir;
		Point(int x,int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}

