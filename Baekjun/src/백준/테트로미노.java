package ����;

import java.util.*;

public class ��Ʈ�ι̳� {
	static int map[][];
	static boolean check[][];
	static int N;
	static int M;
	static int max_result;
	static int max;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		check = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				dfs(i,j,0);
				max = 0;
				exception(i,j);
				max = 0;
			}
		}
		System.out.println(max_result);
	}
	static void dfs(int x, int y, int cnt) {
		if(cnt == 4) {									// 4�� ĭ�� ���� ��������
			if(max > max_result) {						// �� �ִ밪�� ���ݱ��� �ִ밪���� ũ��
				max_result = max;						// max_result �ٲ�
			}
			return;
		}
		check[x][y] = true;
		max += map[x][y];
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];

			if(nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == false) {
				dfs(nx,ny,cnt+1);
			}
		}
		check[x][y] = false;
		max = max - map[x][y];
	}
	static void exception(int x, int y) { // DFS�� ó�� �Ұ����� ���� ��� ó��(�� ,��,��,��)
		if(x-1 >= 0 && x+1 < N && y-1 >= 0) {
			if(max < map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y-1]) {			// ��
				max = map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y-1];
			}
		}
		if(x-1 >= 0 && x+1 < N && y+1 < M) {
			if(max < map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y+1]) {			// ��
				max = map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y+1];
			}
		}
		if(x-1 >= 0 && y-1 >= 0 && y+1 < M) {
			if(max < map[x-1][y] + map[x][y-1] + map[x][y] + map[x][y+1]) {			// ��
				max = map[x-1][y] + map[x][y-1] + map[x][y] + map[x][y+1];
			}
		}
		if(x+1 < N && y-1 >= 0 && y+1 < M) {
			if(max < map[x+1][y] + map[x][y-1] + map[x][y] + map[x][y+1]) {			// ��
				max = map[x+1][y] + map[x][y-1] + map[x][y] + map[x][y+1];
			}
		}
	}
}