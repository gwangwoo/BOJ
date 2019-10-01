import java.io.*;
import java.util.*;

public class _jun_1082 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int R,C;
	static char map[][];
	static boolean check[][];
	static int arr[][];
	static Point D,S,F;
	static int front,rear,ffront,frear;
	static int fq[][] = new int[10001][3];
	static int q[][] = new int[10001][3];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		arr = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ;  j <C ; j++) {
				arr[i][j] = 77777;
			}
		}
		check = new boolean[R][C];
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'D') {
					D = new Point(i,j,0);
					arr[i][j] = (int)1e9;
				}else if(map[i][j] == 'S') {
					S = new Point(i,j,1);
					q[rear][0] = i;
					q[rear][1] = j;
					q[rear++][2] = 1;
					check[i][j] = true;
					map[i][j] = '.';
				}else if(map[i][j] == '*') {
					F = new Point(i,j,0);
					fq[frear][0] = i;
					fq[frear][1] = j;
					fq[frear++][2] = 0;
					arr[i][j] = -1;
				}
			}
		}
		
		while(frear - ffront > 0) {
			int r = fq[ffront][0];
			int c = fq[ffront][1];
			int time = fq[ffront++][2];
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || arr[nr][nc] != 77777) continue;
				if(map[nr][nc] == '.') {
					arr[nr][nc] = time+1;
					fq[frear][0] = nr;
					fq[frear][1] = nc;
					fq[frear++][2] = time+1;
				}
			}
		}
		
		
		int ans = -1;
		while(rear - front > 0) {
			int r = q[front][0];
			int c = q[front][1];
			int time = q[front++][2];
			
			if(r == D.r && c == D.c) {
				ans = time;
			}
			
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || check[nr][nc]) continue;
				if(arr[nr][nc] > time && map[nr][nc] != 'X' && map[nr][nc] != '*') {
					q[rear][0] = nr;
					q[rear][1] = nc;
					q[rear++][2] = time+1;
					check[nr][nc] = true;
				}
			}
			
		}
		
		
		if(ans != -1) System.out.println(ans-1);
		else System.out.println("impossible");
		
		
		
	}
	static class Point {
		int r,c,time;
		Point(int r,int c,int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}
