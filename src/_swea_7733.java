import java.io.*;
import java.util.*;
public class _swea_7733 {
	static int N;
	static int map[][];
	static int res;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int rear,front;
	static int DAY;
	static int q[][] = new int[10000][2];
	static void init(boolean visited[][]) {
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(visited[i],false);
		}
	}
	
	static void bfs(boolean visited[][], int sr,int sc,int day) {
		front = rear = 0;
		visited[sr][sc] = true;
		q[rear][0] = sr;
		q[rear++][1] = sc;
		while(front < rear) {
			int r = q[front][0];
			int c = q[front++][1];
			
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] <= day) continue;
				visited[nr][nc] = true;
				q[rear][0] = nr;
				q[rear++][1] = nc;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			res = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					DAY = Math.max(map[i][j], DAY);
				}
			}
			boolean visited[][] = new boolean[N][N];
			for(int i = 1 ; i <= DAY ; i++) {
				init(visited);
				int cnt = 0;
	 			for(int j = 0 ; j < N ; j++) {
					for(int k = 0 ; k < N ; k++) {
						if(!visited[j][k] && map[j][k] > i) {
							bfs(visited,j,k,i);
							cnt++;
						}
					}
				}
				res = Math.max(cnt, res);
			}
			System.out.println("#"+tc + " " + res);
		}
	}
}
