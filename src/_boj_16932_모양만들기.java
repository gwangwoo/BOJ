import java.io.*;
import java.util.*;

public class _boj_16932_모양만들기 {
	static int N,M;
	static int map[][];
	static int color[][];
	static ArrayList<Integer> cnt = new ArrayList<>();
	static boolean visited[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static ArrayList<Point> cand;
	
	static boolean isCand(int r,int c) {
		int cnt = 0;
		for(int k = 0 ; k <4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(map[nr][nc] == 1) cnt++;
		}
		if(cnt == 0) return false;
		return true;
	}
	
	static void bfs(int r,int c, int val) {
		int count = 1;
		visited[r][c] = true;
		color[r][c] = val;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r;
			c = p.c;
			
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
				color[nr][nc] = val;
				visited[nr][nc] = true;
				q.add(new Point(nr,nc));
				count++;
			}
		}
		cnt.add(count);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		color = new int[N][M];
		visited = new boolean[N][M];
		cand = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					if(isCand(i,j)) cand.add(new Point(i,j));
				}
			}
		}
		// 단지번호 붙이기
		int num = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					bfs(i,j,++num);
				}
			}
		}
		int res = 0;
		for(int i = 0 ; i < cand.size() ; i++) {
			Point now = cand.get(i);
			HashSet<Integer> hs = new HashSet<>();
			for(int k = 0 ; k < 4 ; k++) {
				int nr = now.r + dr[k];
				int nc = now.c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(color[nr][nc] != 0) {
					hs.add(color[nr][nc]);
				}
			}
			ArrayList<Integer> arr = new ArrayList<>(hs);
			if(arr.size() == 1) {
				res = Math.max(res, cnt.get(arr.get(0)-1)+1);
			}else {
				int sum = 1;
				for(int j = 0 ; j < arr.size() ; j++) {
					sum += cnt.get(arr.get(j)-1);
				}
				res = Math.max(res, sum);
			}
			
		}
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
