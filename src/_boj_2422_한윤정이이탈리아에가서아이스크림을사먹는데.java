import java.io.*;
import java.util.*;

public class _boj_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {
	static int N,M;
	static boolean check[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean[N+1][N+1];
		int res = 0;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			check[first][last] = true;
			check[last][first] = true;
		}
		for(int i = 1 ; i <= N-2 ; i++) {
			for(int j = i + 1 ; j <= N-1 ; j++) {
				for(int k = j+1 ; k <= N ; k++) {
					if(check[i][j] || check[j][k] || check[k][i]) continue;
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
