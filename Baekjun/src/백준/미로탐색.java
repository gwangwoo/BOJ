package 백준;

import java.awt.Point;
import java.util.*;

public class 미로탐색 {
	static final int MAX = 101;
	static boolean check[][] = new boolean[MAX][MAX];
	static int dist[][] = new int[MAX][MAX];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int N;
	static int M;
	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //행
		M = sc.nextInt(); //열
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = sc.next();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(0);
		qy.add(0);
		dist[0][0] = 1;
		check[0][0] = true;
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			for(int k = 0 ; k < 4 ; k++) {
				int nx = dx[k] + x;
				int ny = dy[k] + y;
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(map[nx][ny] == 1 && check[nx][ny] == false) {
						check[nx][ny] = true;
						dist[nx][ny] = dist[x][y] + 1;
						qx.add(nx);
						qy.add(ny);
					}
				}
			}
		}
		System.out.println(dist[N-1][M-1]);
	}
}

