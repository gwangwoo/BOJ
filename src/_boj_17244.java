import java.io.*;
import java.util.*;

public class _boj_17244 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int N,M;
	static int W[][];
	static char map[][];
	static Point arr[];
	static int X_cnt = 1;
	static int q[][] = new int[10000][3];
	static int front,rear;
	static boolean visited[][];
	static boolean check[];
	static int res = (int)1e9;

	static int isRight(String str) {
		int ret = 0;
		String target = "0" + str + X_cnt;
		for(int i = 0 ; i < target.length()-1 ; i++) {
			ret += W[target.charAt(i)-'0'][target.charAt(i+1)-'0'];
		}
		return ret;
	}


	static void dfs(int end,String str) {
		if(str.length() == end) {
			res = Math.min(res, isRight(str));
			return;
		}
		for(int i = 1 ; i <= end ; i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(end,str+i);
				check[i] = false;
			}
		}

	}

	static void init() {
		front = rear = 0;
		for(int i = 0 ; i < N ; i++) Arrays.fill(visited[i], false);
	}

	static void bfs(int index) {
		init();
		q[rear][0] = arr[index].r;
		q[rear][1] = arr[index].c;
		q[rear++][2] = 0;
		visited[arr[index].r][arr[index].c] = true;
		while(front < rear) {
			int r = q[front][0];
			int c = q[front][1];
			int d = q[front++][2];

			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == '#') continue;
				if(map[nr][nc] == '.') {
					q[rear][0] = nr;
					q[rear][1] = nc;
					q[rear++][2] = d+1;
					visited[nr][nc] = true;
				}else {
					int val = map[nr][nc]-'0';
					W[index][val] = d+1;
					q[rear][0] = nr;
					q[rear][1] = nc;
					q[rear++][2] = d+1;
					visited[nr][nc] = true;
				}
			}

		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int idx = 1;
		map = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'X') X_cnt++;
			}
		}
		arr = new Point[X_cnt+1];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 'S') {
					arr[0] = new Point(i,j);
					map[i][j] = '0';
				}else if(map[i][j] == 'X') {
					arr[idx] = new Point(i,j);
					map[i][j] = (char) (idx + '0');
					idx++;
				}
			}
		}
		// 마지막 나가는 문.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 'E') {
					arr[X_cnt] = new Point(i,j);
					map[i][j] = (char)(idx+'0');
					break;
				}
			}
		}


		W = new int[X_cnt+1][X_cnt+1];


		for(int i = 0 ; i <= X_cnt ; i++) bfs(i);
		check = new boolean[X_cnt];
		// 조합을 짜주자.
		dfs(X_cnt-1,"");
		System.out.println(res);

//		for(int i = 0 ; i <= X_cnt ; i++) {
//			for(int j = 0 ; j <= X_cnt ; j++) {
//				System.out.print(W[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		//		for(int i = 0 ; i < N ; i++) {
		//			for(int j = 0 ; j < M ; j++) {
		//				System.out.print(map[i][j]);
		//			}
		//			System.out.println();
		//		}
		//		System.out.println(X_cnt);


	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
