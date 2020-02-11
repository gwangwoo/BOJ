import java.io.*;
import java.util.*;
public class _boj_18404 {
	static int sr,sc;
	static int N,M;
	static int map[][];
	static int dr[] = {-1,-2,-2,-1,1,2,2,1};
	static int dc[] = {-2,-1,1,2,2,1,-1,-2};
	
	
	static void bfs(int sr,int sc) {
		Queue<Point> q = new LinkedList<>();
		boolean visited[][] = new boolean[N][N];
		visited[sr][sc] = true;
		q.add(new Point(sr,sc));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			
			for(int k = 0 ; k < 8 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				map[nr][nc] = map[r][c] + 1;
				visited[nr][nc] = true;
				q.add(new Point(nr,nc));
			}
		}
	}
	
	static ArrayList<Point> arl = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken())-1;
		sc = Integer.parseInt(st.nextToken())-1;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			arl.add(new Point(r,c));
		}
		
		bfs(sr,sc);
		for(Point y : arl) {
			System.out.print(map[y.r][y.c] + " ");
		}
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
