import java.util.*;

public class _3184_양 {
	static int R,C;
	static final int dx[] = {-1,0,1,0};
	static final int dy[] = {0,1,0,-1};
	static char map[][];
	static int dist[][];
	static int O = 0,V = 0;

	static void bfs(int x,int y, int cnt) {
		Queue<Point> q = new LinkedList<>();
		dist[x][y] = cnt;
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k< 4 ; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(map[nx][ny] != '#' && dist[nx][ny] == 0) {
					dist[nx][ny] = cnt;
					q.add(new Point(nx,ny));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		dist = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			String str = sc.next();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]== 'o') O++;
				else if(map[i][j] == 'v') V++;
			}
		}


		// 번지번호 붙이기
		int cnt = 0;
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(dist[i][j] == 0 && map[i][j] != '#') {
					bfs(i,j,++cnt);
				}
			}
		}

		for(int k = 1 ; k <= cnt ; k++) {
			int tmp_O = 0;
			int tmp_V = 0;
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++) {
					if(dist[i][j] == k) {
						if(map[i][j] == 'o') tmp_O++;
						if(map[i][j] == 'v') tmp_V++;
					}
				}
			}
			if(tmp_V >= tmp_O) O-=tmp_O;
			else V-=tmp_V;
		}
		System.out.println(O + " " + V);
	}
	static class Point {
		int x,y;
		Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}


}