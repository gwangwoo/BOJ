import java.util.*;

public class _boj_20205 {
	static int N,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int map[][] = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int res[][] = new int[N*K][N*K];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				int val = map[i][j];
				for(int k = i*K ; k < i*K+K ; k++) {
					for(int l = j*K ; l < j*K+K ; l++) {
						res[k][l] = val;
					}
				}
			}
		}
		
		for(int i = 0 ; i < res.length ; i++) {
			for(int j = 0 ; j < res[i].length ; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
