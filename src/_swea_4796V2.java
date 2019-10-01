import java.util.Scanner;

public class _swea_4796V2 {
	static long arr[];
	static int N;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T ; tc++) {
			ans = 0;
			N = sc.nextInt();
			arr = new long[N];
			for(int i = 0 ; i < N ; i++) {
				arr[i] = sc.nextLong();
			}
			
			int up = 0;
			int down = 0;
			int result = 0;
			for(int i = 1 ; i < N ; i++) {
				if(down == 0 && arr[i-1] < arr[i] ) up++;
				else if(arr[i-1] > arr[i]) down++;
				else if(arr[i-1] < arr[i]) {
					result += up* down;
					up = 1;
					down = 0;
				}
			}
			if(down != 0 && up != 0) {
				result += up * down;
			}
			System.out.println("#"+tc + " " + result);
			
		}

	}
}