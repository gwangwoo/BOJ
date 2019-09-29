import java.io.*;
import java.util.*;

public class _boj_16569_화산쇄설류 {
	static int N,M,K;
	static int sr,sc;
	static int map[][];
	static int p_check[][];
	static int check[][];
	static int MAX,cnt;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static ArrayList<MT> mt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		check = new int[M][N];
		p_check = new int[M][N];
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken())-1;
		sc = Integer.parseInt(st.nextToken())-1;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mt = new ArrayList<>();
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int time = Integer.parseInt(st.nextToken());
			check[r][c]= -2;
			mt.add(new MT(r,c,time));

		}
		Collections.sort(mt);
		Queue<MT> q = new LinkedList<>();
		Queue<MT> firq = new LinkedList<>();
		p_check[sr][sc] = 1;
		MAX = map[sr][sc];
		q.add(new MT(sr,sc,map[sr][sc]));
		int time = 0;
		while(true) {
			// 종료조건.
			while(mt.size() != 0 && mt.get(0).time == time) {
				firq.add(mt.get(0));
				mt.remove(0);
			}
			// 화산 전진.
			int firq_size = firq.size();
			while(firq_size-- >0) {
				MT p = firq.poll();
				int r = p.r;
				int c = p.c;

				for(int k = 0 ; k < 4 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
					if(check[nr][nc] != -1) {
						check[nr][nc] = -1;
						firq.add(new MT(nr,nc,p.time));
					}
				}
			}
			// 사람 전진.
			int q_size = q.size();
			while(q_size-- > 0) {
				MT p = q.poll();
				int r = p.r;
				int c = p.c;

				for(int k = 0 ; k < 4 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
					if(check[nr][nc] == 0 && p_check[nr][nc] == 0) {
						p_check[nr][nc]= p_check[r][c] + 1;
						q.add(new MT(nr,nc,map[nr][nc]));
						if(MAX < map[nr][nc]) {
							MAX = map[nr][nc];
							cnt = p_check[nr][nc]-1;
						}
					}
				}
			}
			if(q.size() == 0) break;
			time+=1;		// 1초 증가.
		}
		System.out.println(MAX + " " + cnt);
	}
	static class MT implements Comparable<MT>{
		int r,c,time;
		MT(int r,int c,int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
		@Override
		public int compareTo(MT target) {
			if(this.time < target.time) return -1;
			else if(this.time > target.time) return 1;
			else return 0;
		}
	}
}
