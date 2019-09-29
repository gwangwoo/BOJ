import java.io.*;
import java.util.*;

public class _boj_2468_안전영역 {
	static int N,stand;
	static final int dr[] = {-1,0,1,0};
	static final int dc[] = {0,1,0,-1};
	static int map[][];
	static int rec[][];
	static boolean visited[][];
	static int MAX,res;
	
	static void dfs(int r,int c) {
		visited[r][c] = true;
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(rec[nr][nc] == 1 && !visited[nr][nc]) dfs(nr,nc);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		stand = 0;
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > stand) stand = map[i][j];
			}
		}
		
		for(int k = 0 ; k <= stand ; k++) {
			// k가 0이어야하는이유는 비가 안오는 경우도 존재.
			MAX = 0;
			rec = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(map[i][j] > k) rec[i][j] = 1;
				}
			}
			visited = new boolean[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(rec[i][j] == 1 && !visited[i][j]) {
						dfs(i,j);
						MAX++;
					}
				}
			}
			res = Math.max(res, MAX);
		}
		System.out.println(res);
		
		
	}

}
