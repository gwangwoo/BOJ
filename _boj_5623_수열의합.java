import java.util.*;

public class _boj_5623_수열의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[2][N];
		
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		if(N == 2) {
			if(arr[0][1] == 2) {
				System.out.println("1 1");
				return;
			}
		}
		
		int a1 = (arr[0][1] + arr[0][2] - arr[1][2])/2;
		System.out.print(a1 + " ");
		for(int i = 1 ; i < N ; i++) {
			System.out.print(arr[0][i] - a1 + " " );
		}
	}

}
