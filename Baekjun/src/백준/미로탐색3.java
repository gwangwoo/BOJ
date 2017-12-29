package 백준;

import java.util.*;

public class 미로탐색3 {
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static final int MAX = 101;
	static boolean check[][] = new boolean[MAX][MAX];
	static int dist[][] = new int[MAX][MAX];
	static int N;
	static int M;
	static int Map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		dist[0][0] = 1;
		check[0][0] = true;
		qx.add(0);
		qy.add(0);
		while (!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < N && ny >=0 && ny < M && check[nx][ny] == false && Map[nx][ny] == 1) {
					check[nx][ny] = true;
					qx.add(nx);
					qy.add(ny);
					dist[nx][ny] = dist[x][y] + 1;
				}
			}
		}
		System.out.println(dist[N-1][M-1]);
	}
}
