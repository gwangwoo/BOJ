import java.io.*;
import java.util.*;

public class _boj_16957_체스판위의공 {
	static int N,M;
	static int map[][];
	static int res[][];
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	static int rr,rc;
	static Point his[][];
	static PriorityQueue<Point> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		res = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				res[i][j] = 1;
				pq.add(new Point(map[i][j],i,j));
			}
		}
		while(!pq.isEmpty()) {
			int pq_size = pq.size();
			while(pq_size-- > 0) {
				Point p = pq.poll();
				int idxr = -1; int idxc = -1;
				int MIN = 300001;
				int r = p.r;
				int c = p.c;
				
				for(int k = 0 ; k < 8 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] > map[r][c]) continue;
					if(MIN > map[nr][nc]) {
						MIN = map[nr][nc];
						idxr = nr;
						idxc = nc;
					}
				}
				if(idxr != -1) {
					res[idxr][idxc] += res[r][c];
					res[r][c] = 0;
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j =0  ; j < M ; j++) {
				System.out.print(res[i][j] + " " );
			}
			System.out.println();
		}
	}
	static class Point implements Comparable<Point>{
		int weight,r,c;
		Point(int weight, int r,int c) {
			this.weight = weight;
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Point target) {
			if(this.weight > target.weight) return -1;
			else if(this.weight < target.weight) return 1;
			return 0;
		}
	}
}
