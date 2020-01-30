import java.io.*;
import java.util.*;
public class _boj_18248 {
	static int N,M;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N-1 ; i++) {
			for(int j = i+1 ; j < N ; j++) {
				boolean flag1 = false;
				boolean flag2 = false;
				for(int k = 0 ; k < M ; k++) {
					if(map[i][k] == 0 && map[j][k] == 1) flag1 = true;
					if(map[i][k] == 1 && map[j][k] == 0) flag2 = true;
				}
				if(flag1 && flag2) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}
}