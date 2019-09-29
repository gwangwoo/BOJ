import java.io.*;
import java.util.*;

public class _boj_1799_비숍 {
	static int N;
	static int map[][];
	static int check[][];
	static ArrayList<Point> arl1;
	static ArrayList<Point> arl2;
	static int res,res2;

	static boolean isRight(int r,int c) {
		// \ 대각선 검사.
		for(int i = r+1, j = c+1 ; ; i++,j++) {
			if(i >= N || j >= N) break;
			if(check[i][j] == 1) return false;
		}
		for(int i = r-1, j = c-1 ; ; i--,j--) {
			if(i < 0 || j < 0) break;
			if(check[i][j] == 1) return false;
		}
		// / 대각선 검사.
		for(int i = r-1, j = c+1 ; ; i--,j++) {
			if(i < 0 || j >= N) break;
			if(check[i][j] == 1) return false;
		}
		for(int i = r+1, j = c-1 ; ; i++,j--) {
			if(i >= N || j < 0) break;
			if(check[i][j] == 1) return false;
		}
		return true;
	}
	static void backtracking1(int index,int cnt) {
		if(index == arl1.size()) {
			int val = cnt;
			if(res < val) {
				res = Math.max(res, val);
			}
			return;
		}
		for(int i = index ; i < arl1.size() ; i++) {
			int r = arl1.get(i).r; int c = arl1.get(i).c;
			if(isRight(r,c)) {
				check[r][c] = 1;
				backtracking1(i+1,cnt+1);
				check[r][c] = 0;
			}
		}
	}
	static void backtracking2(int index,int cnt) {
		if(index == arl2.size()) {
			int val = cnt;
			if(res2 < val) {
				res2 = Math.max(res2, val);
			}
			return;
		}
		for(int i = index ; i < arl2.size() ; i++) {
			int r = arl2.get(i).r; int c = arl2.get(i).c;
			if(isRight(r,c)) {
				check[r][c] = 1;
				backtracking2(i+1,cnt+1);
				check[r][c] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new int[N][N];
		arl1 = new ArrayList<>();
		arl2 = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					if((i+j) % 2 == 0) {
						arl1.add(new Point(i,j));
					}else arl2.add(new Point(i,j));
				}
			}
		}	
		check = new int[N][N];
		backtracking1(0,0);
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(check[i], 0);
		}
		backtracking2(0,0);
		System.out.println(res+res2);
	}

	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}

}
