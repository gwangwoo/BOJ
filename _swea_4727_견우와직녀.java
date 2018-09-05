import java.util.*;

public class _swea_4727_°ß¿ì¿ÍÁ÷³à {
	static final int dr[] = {-1,0,1,0};
	static final int dc[] = {0,1,0,-1};
	static int map[][];
	static int N,M;
	static int ans,val;
	static boolean visited[][];
	static ArrayList<Point> arr;
	
	static void bfs(int r,int c) {
		visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new Point(r,c,0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r;
			c = p.c;
			int cnt = p.cnt;
			
			if(r == N-1 && c == N-1) {
				val = cnt;
				return;
			}
			
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(map[nr][nc] == 1 && !visited[nr][nc]) {
					q.add(new Point(nr,nc,cnt+1));
					visited[nr][nc] = true;
				}else if(map[nr][nc] >= 2 && !visited[nr][nc]) {
					if(((cnt+1) % map[nr][nc]) == 0) {
						q.add(new Point(nr,nc,cnt+1));
						visited[nr][nc] = true;
					}else {
						q.add(new Point(r,c,cnt+1));
					}
				}
			}
		}
	}
	
	static boolean isPossible(Point p) {
		int r = p.r;
		int c = p.c;
		ArrayList<Integer> v = new ArrayList<>();
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(map[nr][nc] == 1) v.add(k);
		}
		
		if(v.size() != 2) return false;
		if(Math.abs(v.get(0) - v.get(1)) != 2) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			val = (int)1e9;
			ans = (int)1e9;
			arr = new ArrayList<>();
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 0) {
						arr.add(new Point(i,j,0));
					}
				}
			}
			
			bfs(0,0);
			ans = (int)1e9;
			if(val != 0) ans = Math.min(ans, val);
			val = (int)1e9;
			for(int i = 0 ; i < arr.size() ; i++) {
				Point now = arr.get(i);
				if(isPossible(now)) {
					map[now.r][now.c] = M;
					bfs(0,0);
					ans = Math.min(ans, val);
					map[now.r][now.c] = 0;
				}
			}
			
			System.out.println("#"+tc + " " + ans);
			
		}
		
	}
	static class Point {
		int r,c,cnt;
		Point(int r,int c,int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}