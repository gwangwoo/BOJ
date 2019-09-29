import java.util.*;
// 오버플로우난듯..int 로 잡아줘서 ,,,
public class _15903_카드합체놀이 {
	static long arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long res = 0;
		arr = new long[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextLong();
		}
		for(int i = 0 ; i < M ; i++) {
			Arrays.sort(arr);
			long tmp = arr[0] + arr[1];
			arr[0] = tmp;
			arr[1] = tmp;
		}
		for(int i = 0 ; i < N ; i++) res+=arr[i];
		System.out.println(res);
	}
}
