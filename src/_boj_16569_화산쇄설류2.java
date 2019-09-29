import java.io.*;
import java.util.*;

public class _boj_16569_화산쇄설류2 {
	static int M,N,K;
	static int sr,sc;
	static int map[][];
	static int check[][];
	static int p_check[][];
	static int MAX,cnt;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		p_check = new int[N][M];
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()); sc = Integer.parseInt(st.nextToken());
		for(int i= 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		MAX = map[sr-1][sc-1];
		ArrayList<Point> arl = new ArrayList<>();
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int time = Integer.parseInt(st.nextToken());
			// 화산은 -2;
			check[r][c] = -2;
			arl.add(new Point(r,c,time));
		}
		Collections.sort(arl);
		Queue<Point> firq = new LinkedList<>();
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr-1,sc-1,0));
		p_check[sr-1][sc-1] = 1;
		int time = 0;
		while(true) {
			while(arl.size() != 0 && arl.get(0).time == time) {
				firq.add(arl.get(0));
				arl.remove(0);
			}
			//화산전진.
			int firq_size = firq.size();
			while(firq_size-- >0) {
				Point p = firq.poll();
				int r = p.r;
				int c = p.c;
				
				for(int k = 0 ; k <4 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || check[nr][nc] == -1) continue;
					firq.add(new Point(nr,nc,p.time));
					check[nr][nc] = -1;
				}
			}
			// 사람전진.
			int q_size = q.size();
			while(q_size-- > 0) {
				Point p = q.poll();
				int r = p.r;
				int c = p.c;
				
				for(int k = 0 ; k < 4 ; k++) {
					int nr = r + dr[k];
					int nc = c+  dc[k];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || check[nr][nc] != 0 || p_check[nr][nc] != 0) continue;
					q.add(new Point(nr,nc,p.time));
					p_check[nr][nc] = p_check[r][c] + 1;
					if(MAX < map[nr][nc]) {
						MAX = map[nr][nc];
						cnt = p_check[nr][nc] -1;
					}
				}
			}
			if(q.size() == 0) break;
			time++;
		}
		System.out.println(MAX + " " + cnt);
	}
	static class Point implements Comparable<Point>{
		int r,c,time;
		Point(int r,int c,int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
		@Override
		public int compareTo(Point target) {
			if(this.time < target.time) return -1;
			else if(this.time > target.time) return 1;
			return 0;
		}
	}
}
