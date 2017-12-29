package 백준;

import java.util.*;

public class 째로탈출2 {
	static int N;
	static int M;
	static int dx[] = {0,0,1-1};
	static int dy[] = {1,-1,0,0};
	static char XH[][];
	static int endx;
	static int endy;
	static int ans = -1;
	public static void dfs(int rx, int ry, int bx, int by, int state, int count) {
		if(count > 10)
			return;
		boolean R_check = false;
		boolean B_check = false;
		int R_count = 0;
		int B_count = 0;
		while(XH[rx+dx[state]][ry+dy[state]] == '.') {
			R_count++;
			rx = rx + dx[state];
			ry = ry + dy[state];
			if(rx == endx && ry == endy) { 
				R_check = true;
			}
		}
		while(XH[bx+dx[state]][bx+dy[state]] == '.') {
			B_count++;
			bx = rx + dx[state];
			by = ry + dy[state];
			if(bx == endx && by == endy) { 
				B_check = true;
			}
		}
		if(B_check)
			return;
		
		if(R_check) {
			if(ans == -1 || ans > count) {
				ans = count;
			}
			return;
		}
		if(rx == bx && ry == by) {
			if(R_count > B_count) {
				rx = rx - dx[state];
				ry = ry - dy[state];
			}else {
				bx = bx - dx[state];
				by = by - dy[state];
			}
		}
		for(int i = 0 ; i < 4 ; i++) {
			dfs(rx,ry,bx,by,i,count+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int rx = -1;
		int ry = -1;
		int bx = -1;
		int by = -1;
		int count = 0;
		XH = new char[N][M];
		for(int i = 0 ; i < N; i++) {
			String str = sc.next();
			for(int j = 0 ; j < M; j++) {
				XH[i][j] = str.charAt(j);
				if(XH[i][j] == 'B') {
					bx = i;
					by = j;
					XH[i][j] = '.';
				}
				else if(XH[i][j] == 'R') {
					rx = i;
					ry = j;
					XH[i][j] = '.';
				}
				else if(XH[i][j] == 'O') {
					endx = i;
					endy = j;
					XH[i][j] = '.';
				}
			}
		}
		for(int i = 0 ; i < 4 ; i++) {
			dfs(rx,ry,bx,by,i,1);
		}
		System.out.println(ans);

	}

}
