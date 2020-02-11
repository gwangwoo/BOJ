import java.io.*;
import java.util.*;
public class _boj_18405 {
	static int N,K;
	static int map[][];
	static int S,R,C;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i =0  ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) continue;
				pq.add(new Point(i,j,map[i][j]));
			}
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken())-1;
		C = Integer.parseInt(st.nextToken())-1;
		Queue<Point> q = new LinkedList<>();
		while(S-- > 0) {
			int size = pq.size();
			while(size-- > 0) {
				Point p = pq.poll();
				int r = p.r;
				int c = p.c;

				for(int k = 0 ; k < 4 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0) continue;
					map[nr][nc] = map[r][c];
					q.add(new Point(nr,nc,map[nr][nc]));
				}
			}
			pq.addAll(q);
			q.clear();
		}
		System.out.println(map[R][C]);

	}
	static class Point implements Comparable<Point>{
		int r,c,val;
		Point(int r,int c,int val) {
			this.r = r;
			this.c = c ;
			this.val = val;
		}
		@Override
		public int compareTo(Point target) {
			return this.val - target.val;
		}
	}
}
