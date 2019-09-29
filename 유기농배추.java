package πÈ¡ÿ2;

import java.util.*;

public class ¿Ø±‚≥ÛπË√ﬂ {
	static int n,m;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int[][] map;
	static boolean[][] check;
	public static void dfs(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if(map[nx][ny] == 1 && check[nx][ny] == false) {
					check[nx][ny] = true;
					dfs(nx,ny);
				}
			}
		}
	}

 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- >0) {
			n = sc.nextInt();
			m = sc.nextInt();
			int k = sc.nextInt();
			map = new int[n][m];
			check = new boolean[n][m];
			for(int i = 0 ; i < k ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			
			int section = 0;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					if(map[i][j] == 1 && check[i][j] == false) {
						section++;
//						System.out.println("x¡¬«• : " + i + "y¡¬«• : " + j );
						check[i][j] = true;
						dfs(i,j);
					}
				}
			}
			System.out.println(section);
		}
	}
}
