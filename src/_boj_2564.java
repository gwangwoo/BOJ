import java.io.*;
import java.util.*;
public class _boj_2564 {
	static int H,W,N;
	static int map[][];
	static int sr,sc;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int front,rear;
	static int q[][] = new int[10000][3];
	static boolean check[][];
	static int dist[][];
	
	static void bfs(int sr,int sc) {
		check[sr][sc] = true;
		q[rear][0] = sr;
		q[rear][1] = sc;
		q[rear++][2] = 0;
		while(front < rear) {
			int r = q[front][0];
			int c = q[front][1];
			int val = q[front++][2];
			
			for(int k = 0 ; k <4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == -1 || check[nr][nc]) continue;
				if(map[nr][nc] == 0) {
					check[nr][nc] = true;
					q[rear][0] = nr;
					q[rear][1] = nc;
					q[rear++][2] = val+1;
				}else if(map[nr][nc] != 0) {
					if(dist[nr][nc] == 0) {
						dist[nr][nc] = val+1;
					}else {
						dist[nr][nc] = Math.min(dist[nr][nc], val+1);
					}
					check[nr][nc] = true;
					q[rear][0] = nr;
					q[rear][1] = nc;
					q[rear++][2] = val+1;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken())+1;
		H = Integer.parseInt(st.nextToken())+1;
		N = Integer.parseInt(br.readLine());
		map = new int[H][W];
		check = new boolean[H][W];
		dist = new int[H][W];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			switch(dir) {
			case 1:
				map[0][col] = i;
				break;
			case 2:
				map[H-1][col] = i;
				break;
			case 3:
				map[col][0] = i;
				break;
			case 4:
				map[col][W-1] = i;
				break;
			}
		}
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		switch(dir) {
		case 1:
			sr = 0;
			sc = col;
			break;
		case 2:
			sr = H-1;
			sc = col;
			break;
		case 3:
			sr = col;
			sc = 0;
			break;
		case 4:
			sr = col;
			sc = W-1;
			break;
		}
//		map[sr][sc] = 99;
		for(int i = 1 ; i < H-1 ; i++) {
			for(int j = 1 ; j < W-1 ; j++) {
				map[i][j] = -1;
			}
		}
		
//		for(int i = 0 ; i < H ; i++) {
//			for(int j = 0 ; j < W ; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		bfs(sr,sc);
		int res = 0;
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < W ; j++) {
				if(dist[i][j] == 0) continue;
				res += dist[i][j];
			}
		}
		System.out.println(res);
	}
}
