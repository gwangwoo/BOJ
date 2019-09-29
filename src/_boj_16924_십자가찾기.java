import java.io.*;
import java.util.*;

public class _boj_16924_십자가찾기 {
	static int N,M;	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static char map[][];
	static int check[][];
	static ArrayList<Point> cand;

	static boolean isCand(int r,int c) {
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) return false;
			if(map[nr][nc] == '.') return false;
		}
		return true;
	}

	static int go(int r,int c,int dir, int depth) {
		int val = depth;
		int nr,nc;
		while(true) {
			nr = r + dr[dir];
			nc = c + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) return val;
			if(map[nr][nc] == '.') break;
			val++;
			r = nr; c = nc;
		}
		return val;
	}

	static void painting(int r,int c,int dir,int depth) {
		int nr,nc;
		for(int i = 0 ; i < depth ; i++) {
			nr = r + dr[dir];
			nc = c + dc[dir];
			if(nr < 0 || nr >= N || nc <0 || nc >= M) return;
			check[nr][nc] = 1;
			r = nr;
			c = nc;
		}
		return;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		cand = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// cand 애들 넣어주기.
		for(int i = 1 ; i < N-1 ; i++) {
			for(int j = 1 ; j < M-1 ; j++) {
				if(map[i][j] == '*') {
					if(isCand(i,j)) cand.add(new Point(i,j,0));
				}
			}
		}
		// size가 0인 애들은 -1 처리해준다.
		if(cand.size() == 0) {
			System.out.println(-1);
			return;
		}
		check = new int[N][M];
		ArrayList<Point> res = new ArrayList<>();
		for(int i = 0 ; i < cand.size() ; i++) {
			int r = cand.get(i).r;
			int c = cand.get(i).c;
			int val = Integer.MAX_VALUE;
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				val = Math.min(val, go(nr,nc,k,1));
			}
			check[r][c] = 1;
			res.add(new Point(r+1,c+1,val));
			for(int k = 0 ; k < 4 ; k++) painting(r,c,k,val);
		}
		// 마지막 검사.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == '*' && check[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		if(res.size() > N*M) {
			System.out.println(-1);
			return;
		}
		// result print
		System.out.println(res.size());
		for(int i = 0 ; i < res.size() ; i++) {
			System.out.println(res.get(i).r + " " + res.get(i).c + " " + res.get(i).depth);
		}


	}
	static class Point {
		int r,c,depth;
		Point(int r,int c,int depth){
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}

}
