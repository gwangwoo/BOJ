package 새출발0415;

import java.util.*;

public class 치즈_0421 {
	static int N,M;
	static int map[][];
	static int visited[][];
	static final int dx[] = {-1,0,1,0};
	static final int dy[] = {0,1,0,-1};
	static int time = 0;

	static int search(int x,int y) {
		int cnt = 0;
		for(int k = 0 ; k < 4 ; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx< 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(map[nx][ny] == 0) cnt++;
		}
		if(cnt >= 2) return 0;
		return 1;
	}

	static void bfs(int x,int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visited[x][y] = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;
			for(int k = 0 ; k < 4 ; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(map[nx][ny] == 0 && visited[nx][ny] == 0) {
						q.add(new Point(nx,ny));
						visited[nx][ny] = 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		while(true) {
			// 1. 바깥공기 숫자바꿔주기.
			bfs(0,0);
			// 2. 안쪽공기 숫자 2로 바꿔주기.
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(visited[i][j] == 0 && map[i][j] == 0) {
						map[i][j] = 2;
					}
				}
			}
			// 바꿧으니까 visited는 초기화
			for(int i = 0 ; i < N ; i++) {
				Arrays.fill(visited[i], 0);
			}
			
			// 임시로 담아두기 위해서 임시 배열 생성.
			int tmp[][] = new int[N][M];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			// 1초지났을때를 기록.
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j] == 1) {
						tmp[i][j] = search(i,j);
					}
				}
			}
			// 원래 맵에 매핑
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					map[i][j] = tmp[i][j];
				}
			}
			// 갯수 세어주기.
			int num = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j] == 1) {
						num++;
					}
				}
			}
			// 내부에있던 공기들을 다시 원래의0으로 저장.
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j] == 2) {
						map[i][j] = 0;
					}
				}
			}
			time++;
			if(num == 0) break;
		}
		System.out.println(time);
	}
	static class Point {
		int x,y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
