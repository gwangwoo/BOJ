import java.io.*;
import java.util.*;

public class _boj_20116 {
	static int N;
	static long L;
	static long arr[];
	static long psum[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		arr = new long[N+1];
		psum = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			psum[i] = psum[i-1] + arr[i];
		}
		boolean flag = false;
		for(int i = N ; i > 1 ; i--) {
			double exp = (psum[N]-psum[i-1]) / (double)(N-(i-1));
			if(arr[i-1]-L < exp && exp < arr[i-1]+L) continue;
			else {
				flag = true;
				break;
			}
		}
		System.out.println(flag?"unstable":"stable");
	}
}