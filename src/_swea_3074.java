import java.io.*;
import java.util.*;
public class _swea_3074 {
	static int N,M;
	static long arr[];
	static boolean isPossible(long time) {
		long cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			cnt += (time / arr[i]); 
		}
		if(cnt >= M) return true;
		else return false;
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new long[N];
			long ans = 0;
			long left = 0,right = (long)1e18;
			for(int i = 0 ; i < N ; i++) {
				arr[i] = Long.parseLong(br.readLine());
			}
			while(left <= right) {
				long mid = (left + right) >> 1;
				if(isPossible(mid)) {
					ans = mid;
					right = mid-1;
				}else left = mid+1;
			}
			System.out.println("#"+tc + " " + ans);
			
		}
	}
}
