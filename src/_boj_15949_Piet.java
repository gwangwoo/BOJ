import java.io.*;
import java.util.*;
// 현재 블록에서 어떤 블록으로 이동할지를 결정하기 위해 
// DP(Direction Pointer)와 CC(Codel Chooser)라는 두 가지 값이 존재한다.

public class _boj_15949_Piet {
	static int N,M;
	static StringBuilder sb;
	static char map[][];
	static int dr[] = {0,1,0,-1};		// 동 남 서 북.
	static int dc[] = {1,0,-1,0};
	static int DP,CC;	// 
	static int sr,sc;
	static ArrayList<Point> Top,Bottom,Left,Right;
	
	static void bfs(int sr,int sc, int tmp[][]) {
		sb.append(map[sr][sc]);
		tmp[sr][sc] = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr,sc));
		while(!q.isEmpty()) {
			Point p =q.poll();
			int r = p.r;
			int c = p.c;
			
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || tmp[nr][nc] != 0) continue;
				if(map[nr][nc] == map[r][c]) {
					tmp[nr][nc] = 1;
					map[nr][nc] = map[r][c];
					q.add(new Point(nr,nc));
				}
			}
		}
	}
	
	
	static void init() {
		Top.clear();
		Bottom.clear();
		Left.clear();
		Right.clear();
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Top = new ArrayList<>();
		Bottom = new ArrayList<>();
		Left = new ArrayList<>();
		Right = new ArrayList<>();
		DP = 0; CC = -1;
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int time = 0;
		while(true) {
			if(time == 9) break;
			int tmp[][] = new int[N][M];
			bfs(sr,sc,tmp);
			
		}
		
	}
	static class Point {
		int r,c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
