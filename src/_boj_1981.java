import java.io.*;
import java.util.*;

public class _boj_1981 {
	static int N;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int MAX,MIN;
	static int arr[][];
	static boolean visited[][];
	static Queue<Point> q = new LinkedList<>();
	static void init() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				visited[i][j] = true;
			}
		}
		q.clear();
	}
	static boolean bfs(int diff) {
		for(int i = MIN ; i <= MAX ; i++) {
			init();
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < N ; k++) {
					if(i <= arr[j][k] && arr[j][k] <= i+diff) visited[j][k] = false;
				}
			}
			q.add(new Point(0,0));

			while(!q.isEmpty()) {
				Point p = q.poll();
				int r = p.r;
				int c = p.c;

				if(visited[r][c]) continue;
				visited[r][c] = true;
				
				if(r == N-1 && c == N-1) {
					return true;
				}

				for(int k = 0 ; k < 4 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
					q.add(new Point(nr,nc));

				}
			}
		}
		return false;

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		MAX = 0; MIN = 201;
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				MAX = Math.max(arr[i][j], MAX);
				MIN = Math.min(arr[i][j], MIN);
			}
		}

		int left = 0; int right = 201;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(bfs(mid)) right = mid-1;
			else left = mid+1;
		}
		System.out.println(right+1);

	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
