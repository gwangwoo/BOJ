import java.io.*;
import java.util.*;

public class _boj_10656_십자말풀이 {
	static int N,M;
	static char map[][];
	
	static boolean isRow(Point p) {
		int r = p.r;
		int c = p.c;
		if(r + 2 >= N) return false;
		for(int i = r ; i < r+3 ; i++) {
			if(map[i][c] != '.') return false;
		}
		if(r-1 < 0 || map[r-1][c] == '#') return true;
		return false;
	}
	
	static boolean isCol(Point p) {
		int r = p.r;
		int c = p.c;
		if(c + 2 >= M) return false;
		for(int i = c ; i < c+3 ; i++) {
			if(map[r][i] != '.') return false;
		}
		if(c-1 < 0 || map[r][c-1] == '#') return true;
		return false;
	}
	
	static ArrayList<Point> res = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		ArrayList<Point > cand = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '.') cand.add(new Point(i,j));
			}
		}
		for(int i = 0 ; i < cand.size() ; i++) {
			if(isRow(cand.get(i))) {
				res.add(cand.get(i));
			}else if(isCol(cand.get(i))) {
				res.add(cand.get(i));
			}
		}
		System.out.println(res.size());
		for(int i = 0 ; i < res.size() ;i++) {
			System.out.println(res.get(i).r+1 + " " + (res.get(i).c+1));
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
