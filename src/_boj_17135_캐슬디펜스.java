import java.io.*;
import java.util.*;

public class _boj_17135_캐슬디펜스 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int N,M,D;
	static int map[][];
	static int res;
	static int tmp[][];
	static Queue<Point> q;
	static ArrayList<Solider> arr;
	
	static boolean clearMap(int tmp[][]) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(tmp[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	static void moveDown(int tmp[][]) {
		for(int i = N-1 ; i >= 0 ; i--) {
			for(int j = 0 ; j < M ; j++) {
				if(i == N-1) tmp[i][j] = 0;
				else {
					tmp[i+1][j] = tmp[i][j];
					tmp[i][j] = 0;
				}
			}
		}
	}
	
	static Point bfs(int sr,int sc) {
		q.clear();
		int visited[][] = new int[N+1][M];
		visited[sr][sc] = 1;
		q.add(new Point(sr,sc));
		arr.clear();
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			
			if(visited[r][c] == D+1) continue;
			
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] != 0) continue;
				if(tmp[nr][nc] == 0) {
					q.add(new Point(nr,nc));
					visited[nr][nc] = visited[r][c] + 1;
 				}else if(tmp[nr][nc] == 1) {
 					q.add(new Point(nr,nc));
 					visited[nr][nc] = visited[r][c] + 1;
 					arr.add(new Solider(nr,nc,visited[r][c]));
 				}
			}
		}
		
		if(arr.size() == 0) return null;
		Collections.sort(arr);
		Point po = new Point(arr.get(0).r,arr.get(0).c);
		return po;
		
	}
	
	static int go(int map[][],int r1,int c1,int r2,int c2,int r3,int c3) {
		int val = 0;
		for(int i = 0 ; i < N+1 ; i++) {
			for(int j = 0 ; j < M ; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		while(true) {
			Point val1 = bfs(r1,c1);
			Point val2 = bfs(r2,c2);
			Point val3 = bfs(r3,c3);
			if(val1 != null) {
				val += tmp[val1.r][val1.c];
				tmp[val1.r][val1.c] = 0;
			}
			if(val2 != null) {
				val += tmp[val2.r][val2.c];
				tmp[val2.r][val2.c] = 0;
			}
			if(val3 != null) {
				val += tmp[val3.r][val3.c];
				tmp[val3.r][val3.c] = 0;
			}
			moveDown(tmp);
			if(clearMap(tmp)) break;
		}
		
		
		
		return val;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		arr = new ArrayList<>();
		map = new int[N+1][M];
		tmp = new int[N+1][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 궁수 3명 놓기.
		for(int i = 0 ; i < M-2; i++) {
			map[N][i] = 9;
			for(int j = i+1 ; j < M-1 ; j++) {
				map[N][j] = 9;
				for(int k = j+1 ; k < M ; k++) {
					map[N][k] = 9;
					int val = go(map,N,i,N,j,N,k);
					res = Math.max(val, res);
					map[N][k] = 0;
				}
				map[N][j] = 0;
			}
			map[N][i] = 0;
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
	static class Solider implements Comparable<Solider> {
		int r,c,dist;
		Solider(int r,int c,int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		@Override
		public int compareTo(Solider target) {
			if(this.dist < target.dist) return -1;
			else if(this.dist > target.dist) return 1;
			else {
				if(this.c < target.c) return -1;
				else if(this.c > target.c) return 1;
				else return 0;
			}
		}
		
	}
}
