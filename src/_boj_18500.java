import java.io.*;
import java.util.*;
public class _boj_18500 {
	static int R,C,N;
	static char map[][];
	static boolean visited[][];
	static int dr[] = {-1,0,0,1};
	static int dc[] = {0,-1,1,0};

	static void init() {
		for(int i = 0; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	static void print(char arr[][]) {
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void copy(char now[][], char target[][]) {
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				target[i][j] = now[i][j];
			}
		}
	}

	static void bfs(int sr,int sc) {
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> arl = new ArrayList<>();
		visited[sr][sc] = true;
		arl.add(new Point(sr,sc));
		q.add(new Point(sr,sc));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;

			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.' || visited[nr][nc]) continue;
				q.add(new Point(nr,nc));
				arl.add(new Point(nr,nc));
				visited[nr][nc] = true;
			}
		}
		Collections.sort(arl);
		// 땅에 붙어 있으면 안떨어짐.
		if(arl.get(0).r == R-1) return;
		while(true) {
			ArrayList<Point> tmp_arl = new ArrayList<>();
			// 한칸씩 내려보면서 내려갈수 있으면 전체를 다 내린다.
			char tmp[][] = new char[R][C];
			copy(map, tmp);
			int n = arl.size();
			boolean flag = false;
			for(int i = 0 ; i < n ; i++) {
				Point now = arl.get(i);
				if(now.r+dr[3] == R) return;
				if(tmp[now.r+dr[3]][now.c] == '.') {
					tmp[now.r][now.c] = '.';
					tmp[now.r+dr[3]][now.c] = 'x';
					tmp_arl.add(new Point(now.r+dr[3], now.c));
				}else {
					flag = true;
					break;
				}
			}
			if(flag) {
				return;
			}
			else {
				copy(tmp,map);
				arl.clear();
				arl.addAll(tmp_arl);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int tc = 0 ; tc < N ; tc++) {
			init();
			boolean flag = false;
			int input_r = R - Integer.parseInt(st.nextToken());
			int input_c = -1;
			if(tc % 2 == 0) {
				// 창영ㅇ이
				for(int j = 0 ; j < C ; j++) {
					if(map[input_r][j] == 'x') {
						input_c = j;
						flag = true;
						break;
					}
				}
			}else {
				// 나머지.
				for(int j = C-1 ; j >= 0 ; j--) {
					if(map[input_r][j] == 'x') {
						input_c = j;
						flag = true;
						break;
					}
				}
			}
			if(!flag) continue;
			map[input_r][input_c] = '.';
			// < ^ > 에서 바닥과 떨어진애만 찾으면되지 않을까?
			for(int k = 0 ; k < 4 ; k++) {
				int nr = input_r + dr[k];
				int nc = input_c + dc[k];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.' || visited[nr][nc]) continue;
				bfs(nr,nc);
			}
		}
		for(int i = 0 ; i < R ; i++) {
			for(int j =0  ; j < C ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}
	static class Point implements Comparable<Point> {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}		
		@Override
		public int compareTo(Point target) {
			if(this.r > target.r) return -1;
			else if(this.r < target.r) return 1;
			return 0;
		}

	}
}
