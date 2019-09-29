import java.io.*;
import java.util.*;

public class _swea_1767_프로세서연결하기 {
	static int N;
	static int map[][];
	static int res;
	static int pnum;
	static final int dr[] = {-1,0,1,0};
	static final int dc[] = {0,1,0,-1};
	static ArrayList<Point> arr;
	
	static void delete(int r,int c,int dir) {
		if(dir == 0) {
			for(int i = r ; i >= 0 ; i--) {
				map[i][c] = 0;
			}
		}else if(dir == 2) {
			for(int i = r ; i < N ; i++) {
				map[i][c] = 0;
			}
		}else if(dir == 1) {
			for(int j = c ; j < N ; j++) {
				map[r][j] = 0;
			}
		}else if(dir == 3) {
			for(int j = c ; j >= 0 ; j--) {
				map[r][j] = 0;
			}
		}
	}
	
	
	static int draw(int r,int c,int dir) {
		int ans = 0;
		if(dir == 0) {
			for(int i = r ; i >= 0 ; i--) {
				map[i][c] = 2;
				ans++;
			}
		}else if(dir == 2) {
			for(int i = r ; i < N ; i++) {
				map[i][c] = 2;
				ans++;
			}
		}else if(dir == 1) {
			for(int j = c ; j < N ; j++) {
				map[r][j] = 2;
				ans++;
			}
		}else if(dir == 3) {
			for(int j = c ; j >= 0 ; j--) {
				map[r][j] = 2;
				ans++;
			}
		}
		return ans;
	}
	
	static boolean isPossible(int r,int c,int dir) {
		if(dir == 0) {
			for(int i = r ; i >= 0 ; i--) {
				if(map[i][c] != 0) return false;
			}
		}else if(dir == 2) {
			for(int i = r ; i < N ; i++) {
				if(map[i][c] != 0) return false;
			}
		}else if(dir == 1) {
			for(int j = c ; j < N ; j++) {
				if(map[r][j] != 0) return false;
			}
		}else if(dir == 3) {
			for(int j = c ; j >= 0 ; j--) {
				if(map[r][j] != 0) return false;
			}
		}
		return true;
	}
	
	static void dfs(int idx,int num,int sum) {
		if(idx == arr.size()) {
			if(pnum < num) {
				res = sum;
				pnum = num;
			}else if(pnum == num) {
				res = Math.min(res, sum);
			}
		}else {
			int r = arr.get(idx).r;
			int c = arr.get(idx).c;
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(isPossible(nr,nc,k)) {
//					System.out.println(r + " " + c + " " + k);
					dfs(idx+1,num+1,sum+draw(nr,nc,k));
					delete(nr,nc,k);
				}
			}
			dfs(idx+1,num,sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			arr = new ArrayList<>();
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1) {
						if(i == 0 || j == 0 || i == N-1 || j == N-1) continue;
						arr.add(new Point(i,j));
					}
				}
			}
			pnum = 0;
			res = Integer.MAX_VALUE;
			dfs(0,0,0);
			System.out.println("#"+tc+ " " + res);
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