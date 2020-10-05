import java.util.*;

public class _swea_10571 {
	static int map[][];
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int r_max[] = new int[N];
			int c_max[] = new int[M];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					r_max[i] = Math.max(r_max[i], map[i][j]);
				}
			}
			
			for(int i = 0 ; i < M ; i++) {
				for(int j = 0 ; j < N ; j++) {
					c_max[i] = Math.max(c_max[i], map[j][i]);
				}
			}
		
			boolean flag = false;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j] == r_max[i] || map[i][j] == c_max[j]) continue;
					flag = true;
					break;
				}
				if(flag) break;
			}
			if(flag) System.out.println("#"+tc + " NO");
			else System.out.println("#"+tc + " YES");
		
		}
	}
}
