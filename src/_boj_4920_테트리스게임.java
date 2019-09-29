import java.io.*;
import java.util.*;

public class _boj_4920_테트리스게임 {
	static int N;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int map[][];
	static int MAX;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			MAX = Integer.MIN_VALUE;
			++tc;
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine(), "  ");
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// ㅗ 
			for(int i = 1 ; i < N ; i++) {
				for(int j = 1 ; j < N-1 ; j++) {
					int sum = map[i][j-1] + map[i][j] + map[i-1][j] + map[i][j+1];
					MAX = Math.max(sum, MAX);
				}	
			}
			// ㅏ
			for(int i = 1 ; i < N-1 ; i++) {
				for(int j = 0 ; j < N-1 ; j++) {
					int sum = map[i][j] + map[i-1][j] + map[i+1][j] + map[i][j+1];
					MAX = Math.max(sum, MAX);
				}
			}
			// ㅜ 
			for(int i = 0 ; i < N-1 ; i++) {
				for(int j = 1 ; j < N-1 ; j++) {
					int sum = map[i][j-1] + map[i][j] + map[i+1][j] + map[i][j+1];
					MAX = Math.max(sum, MAX);
				}	
			}
			// ㅓ
			for(int i = 1 ; i < N-1 ; i++) {
				for(int j = 1 ; j < N ; j++) {
					int sum = map[i][j] + map[i-1][j] + map[i+1][j] + map[i][j-1];
					MAX = Math.max(sum, MAX);
				}
			}
			// ㅡ
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N-4 ; j++) {
					int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
					MAX = Math.max(sum, MAX);
				}
			}
			// ㅣ
			for(int i = 0 ; i < N-4 ; i++) {
				for(int j = 0 ; j < N ; j++) {
					int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
					MAX = Math.max(sum, MAX);
				}
			}
			// ㅁ
			for(int i = 0 ; i < N-1 ; i++) {
				for(int j = 0 ; j < N-1 ; j++) {
					int sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
					MAX = Math.max(MAX, sum);
				}
			}
			// z
			for(int i = 0 ; i < N-1 ; i++) {
				for(int j = 1 ; j < N-1 ; j++) {
					int sum = map[i][j] + map[i+1][j] + map[i][j-1] + map[i+1][j+1];
					MAX = Math.max(MAX, sum);
				}
			}
			// z회전
			for(int i = 1 ; i < N-1 ; i++) {
				for(int j = 1 ; j < N ; j++) {
					int sum = map[i][j] + map[i-1][j] + map[i][j-1] + map[i+1][j-1];
					MAX = Math.max(MAX, sum);
				}
			}
			// ㄱ
			for(int i = 0 ; i < N-1 ; i++) {
				for(int j = 1 ; j < N-1 ; j++) {
					int sum = map[i][j] + map[i][j-1] + map[i][j+1] + map[i+1][j+1];
					MAX = Math.max(MAX, sum);
				}
			}
			// J
			for(int i = 2 ; i < N ;i++) {
				for(int j = 1 ; j < N ; j++) {
					int sum = map[i][j] + map[i][j-1] + map[i-1][j] + map[i-2][j];
					MAX = Math.max(MAX, sum);
				}
			}
			// ㄴ
			for(int i = 1 ; i < N ; i++) {
				for(int j = 1 ; j < N-1 ; j++) {
					int sum = map[i][j] + map[i][j-1] + map[i][j+1] + map[i-1][j-1];
					MAX = Math.max(MAX, sum);
				}
			}
			// J 반대
			for(int i = 0 ; i < N-2 ;i++) {
				for(int j = 0 ; j < N-1 ; j++) {
					int sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
					MAX = Math.max(MAX, sum);
				}
			}
			System.out.println(tc+ ". " + MAX);

		}
	}

}
