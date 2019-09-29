import java.io.*;
import java.util.*;

public class _boj_15684_사다리조작 {
	static int map[][];
	static int N,M,H;
	static int ans = (int)1e9;
	static void dfs(int r,int c, int cnt) {
		if(simulation()) {
			ans = Math.min(ans, cnt);
			return;
		}

		if(cnt == 3) return;

		for(int i = r ; i <= H ; i++) {
			for(int j = 1 ; j < N ; j++) {
				if(map[i][j] == 0  && map[i][j-1] != 1 && map[i][j+1] == 0) {
					int tmp1 = map[i][j];
					int tmp2 = map[i][j+1];
					map[i][j] = 1;
					map[i][j+1] = -1;
					dfs(i,j,cnt+1);
					map[i][j] = tmp1;
					map[i][j+1] = tmp2;
				}
			}
		}
	}
	static boolean simulation() {
		for(int i = 1 ; i <= N ; i++) {
			int now = i;
			// go
			int j = 1;
			while(true) {
				if(j == H+1) break;
				if(map[j][now] == 1) now += map[j][now];
				else if(map[j][now] == -1) now += map[j][now];
				j++;
			}
			if(now != i) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H+2][N+1];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[u][v+1] = -1; 
		}
		// 0개 놔도 되는 전처리.
		if(simulation()) {
			System.out.println(0);
			return;
		}
		dfs(1,1,0);
		if(ans == (int)1e9) System.out.println(-1);
		else System.out.println(ans);
	}
}
