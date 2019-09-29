import java.io.*;
import java.util.*;
public class _boj_1743 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int N,M,K;
	static boolean visited[][];
	static int map[][];
	static int q[][] = new int[10001][2];
	static int front,rear;
	
	static int bfs(int sr,int sc) {
		int ret = 1;
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
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
				ret++;
				q[rear][0] = nr;
				q[rear++][1] = nc;
				visited[nr][nc] = true;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = 1;
		}
		int MAX = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 1) {
					int val = bfs(i,j);
					MAX = Math.max(val, MAX);
				}
			}
		}
		System.out.println(MAX);
	}
}
