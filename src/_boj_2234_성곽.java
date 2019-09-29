import java.io.*;
import java.util.*;

public class _boj_2234_성곽 {
	static int N,M;
	static int map[][];
	static int visited[][];
	static int dr[] = {0,-1,0,1};
	static int dc[] = {-1,0,1,0};	
	static int MAX;
	static ArrayList<Integer> arr = new ArrayList<>();
	static void bfs(int r,int c, int cnt) {
		Queue<Point> q = new LinkedList<>();
		visited[r][c] = cnt;
		int res = 1;
		q.add(new Point(r,c));
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r;
			c = p.c;
			int val = map[r][c];
			for(int k = 0 ; k < 4 ; k++) {
				if((val & (1 << k)) != 0) continue;
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] != 0) continue;
				visited[nr][nc] = cnt;
				res++;
				q.add(new Point(nr,nc));
			}
		}
		arr.add(res);
		MAX = Math.max(MAX, res);

	}



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(visited[i][j] == 0) {
					bfs(i,j,cnt++);
				}
			}
		}
		int total = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(i+1 < N && visited[i][j] != visited[i+1][j]) {
					int sum = arr.get(visited[i][j]-1) + arr.get(visited[i+1][j]-1);
					total = Math.max(sum, total);
				}
				if(j+1 < M && visited[i][j] != visited[i][j+1]) {
					int sum = arr.get(visited[i][j]-1) + arr.get(visited[i][j+1]-1);
					total = Math.max(sum, total);
				}

			}
		}
		System.out.println(arr.size());
		System.out.println(MAX);
		System.out.println(total);

	}

	static class Point {
		int r,c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

