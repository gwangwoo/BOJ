package 백준;
import java.util.*;

public class 테트로미노2 {

	static int map[][];
	static int N;
	static int M;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int sum;
	static int result;
	static boolean check[][];


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
				sum = 0;
				exception(i,j);
				sum =0;
			}
		}
		System.out.println(result);
	}
	public static void dfs(int x, int y, int cnt) {
		if(cnt == 4) {
			if(sum > result)
				result = sum;
			return;
		}
		check[x][y] = true;
		sum = sum + map[x][y];
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == false) {
				dfs(nx,ny,cnt+1);
			}
		}
		check[x][y] = false;
		sum = sum - map[x][y];
	}
	public static void exception(int x, int y) {			// ㅜ ,ㅗ, ㅓ, ㅏ 경우
		if(x-1 >= 0 && x+1 < N && y-1 >=0) {
			if(result < map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y-1]) {
				result = map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y-1];
			}
		}
		if(x-1 >= 0 && x+1 < N && y+1 < M) {
			if(result < map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y+1]) {
				result = map[x-1][y] + map[x][y] + map[x+1][y] + map[x][y+1];
			}
		}
		if(x-1 >= 0 && y+1 < M && y-1 >=0) {
			if(result < map[x-1][y] + map[x][y-1] + map[x][y] + map[x][y+1]) {
				result = map[x-1][y] + map[x][y-1] + map[x][y] + map[x][y+1];
			}
		}
		if(x+1 < N && y+1 < M && y-1 >=0) {
			if(result < map[x+1][y] + map[x][y] + map[x][y-1] + map[x][y+1]) {
				result = map[x+1][y] + map[x][y] + map[x][y-1] + map[x][y+1];
			}
		}
	}
}