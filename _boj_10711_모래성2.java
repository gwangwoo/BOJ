import java.io.*;
import java.util.*;

public class _boj_10711_모래성2 {
	static int H,W,res;
	static char map[][];
	static int arr[][];
	static boolean visited[][];	 // 모래성의 유무.
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> nq = new LinkedList<>();

	static void bfs() {

		while(!q.isEmpty()) {
			res++;
			int q_size = q.size();
			while(q_size-- >0) {
				Point p = q.poll();
				int r = p.r;
				int c = p.c;
				// 모래성 파괴.
				map[r][c] = '.';
				arr[r][c] = 0;
				// 바다가 생겼으니 주위 애들한테 바다가 1개 추가됐다는걸 갱신.
				for(int k = 0 ; k < 8 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
					if(map[nr][nc] != '.' && visited[nr][nc]) {
						arr[nr][nc]++;
						// 만약 모래성이 깨질 조건이라면 큐에 넣어 다음 시간에 없어줘야됌.
						if(arr[nr][nc] >= map[nr][nc]-'0') {
							// 모래성이 깨질 애 니깐 31번째 줄에 다음 탐색에 들어가게 하지않기 위해 visited[nr][nc] = false; 로 고쳐준다.
							visited[nr][nc] = false;
							q.add(new Point(nr,nc));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		arr = new int[H][W];
		visited = new boolean[H][W];

		for(int i = 0 ; i < H ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < W ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] != '.') {
					visited[i][j] = true;
				}
			}
		}

		// 모래성 주위의바다체크.
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < W ; j++) {
				if(visited[i][j]) {
					int val = 0;
					for(int k = 0 ; k < 8 ; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
						if(map[nr][nc] == '.') val++;
					}
					arr[i][j] = val;
					if(val >= map[i][j]-'0') {
						q.add(new Point(i,j));
						visited[i][j] = false;
					}
				}
			}
		}
		bfs();
		System.out.println(res);

	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
