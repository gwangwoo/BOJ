import java.io.*;
import java.util.*;
public class _boj_18311 {
	static int N;
	static long K;
	static long arr[];
	static long brr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		arr = new long[N+1];
		brr = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if(i == 1) continue;
			arr[i] += arr[i-1];
		}
		for(int i = N ; i >= 0 ; i--) brr[N-i] = -arr[i];
		if(arr[N] < K) {
			long val = K-arr[N]*2;
			int idx = Arrays.binarySearch(brr, val);
			if(idx < 0) {
				System.out.println(N+2+idx);
			}
			else {
				System.out.println(N-idx);
			}
		}else {
			int idx = Arrays.binarySearch(arr, K);
			if(idx < 0) {
				idx = Math.abs(idx)-1;
				System.out.println(idx);
			}else if(idx == N) {
				System.out.println(idx);
			}else {
				System.out.println(idx+1);
			}
		}
	}
}