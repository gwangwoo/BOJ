import java.util.*;

public class _boj_10025_∞‘¿∏∏•πÈ∞ı {
	static int arr[];
	static int N,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[1000001];
		
		for(int i = 0 ; i < N ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[b] = a;
		}
		K = K*2 + 1;
		int sum = 0;
		int res = 0;
		for(int i = 0 ; i <= 1000000 ; i++) {
			if(i >= K) sum -= arr[i-K];
			sum += arr[i];
			res = Math.max(sum, res);
		}
		System.out.println(res);
		
	}

}
