import java.io.*;


import java.util.*;
public class _boj_3987 {
	static char map[][];
	static int sr,sc;
	static int N,M;
	static int dr[] = {-1,0,1,0};	// 북 동 남 서.
	static int dc[] = {0,1,0,-1};
	static boolean visited[][][];
	
	static void init() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				for(int k = 0 ; k < 4 ;k++) visited[i][j][k] = false; 
			}
		}
	}
	
	static int gogame(int r,int c,int dir, int time,int ori) {
		init();
		// 움직이는 거 짜면될듯.
		// '/' 만났을떄 '\' 만났을때 처리 들어온 방향과 비교하면서. 
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c,dir));
		visited[r][c][dir] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r;
			c = p.c;
			dir = p.dir;
			
//			System.out.println(r + " " + c + " " + dir + " " + time);
			// 다음칸.
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) return time+1;
			if(visited[nr][nc][dir]) {
				switch(ori) {
				case 0:
					System.out.println("U");
					break;
				case 1:
					System.out.println("R");
					break;
				case 2:
					System.out.println("D");
					break;
				case 3:
					System.out.println("L");
					break;
				}
				System.out.println("Voyager");
				System.exit(0);
			}
			switch(map[nr][nc]) {
			case '.':
				q.add(new Point(nr,nc,dir));
				visited[nr][nc][dir] = true;
				break;
			case 'C':
				return time+1;
			case '/':
				if(dir == 0) {
					q.add(new Point(nr,nc,1));
					visited[nr][nc][1] = true;
				}else if(dir == 3) {
					q.add(new Point(nr,nc,2));
					visited[nr][nc][2] = true;
				}else if(dir == 1) {
					q.add(new Point(nr,nc,0));
					visited[nr][nc][0] = true;
				}else if(dir == 2) {
					q.add(new Point(nr,nc,3));
					visited[nr][nc][3] = true;
				}
				break;
			case '\\':
				if(dir == 0) {
					q.add(new Point(nr,nc,3));
					visited[nr][nc][3] = true;
				}else if(dir == 1) {
					q.add(new Point(nr,nc,2));
					visited[nr][nc][2] = true;
				}else if(dir == 2) {
					q.add(new Point(nr,nc,1));
					visited[nr][nc][1] = true;
				}else if(dir == 3) {
					q.add(new Point(nr,nc,0));
					visited[nr][nc][0] = true;
				}
				break;
			}
			time++;
		}
		return time;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][4];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken())-1;
		sc = Integer.parseInt(st.nextToken())-1;
		int MAX = 0;
		int command = -1;
		for(int k = 0 ; k < 4 ; k++) {
			int val = gogame(sr,sc,k,0,k);
			if(MAX < val) {
				MAX = val;
				command = k; 
			}
		}
		switch(command) {
		case 0:
			System.out.println("U");
			break;
		case 1:
			System.out.println("R");
			break;
		case 2:
			System.out.println("D");
			break;
		case 3:
			System.out.println("L");
			break;
		}
		System.out.println(MAX);
	}
	static class Point {
		int r,c,dir;
		Point(int r,int c,int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}