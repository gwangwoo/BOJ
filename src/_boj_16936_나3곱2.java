import java.util.*;
import java.io.*;

public class _boj_16936_나3곱2 {
	static HashSet<Long> hs = new HashSet<>();
	static int N;
	static long arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			hs.add(arr[i]);
		}
		int idx = 0;
		// 소인수 분해해서 %3 은 많고 %2은 적은 수 찾기.
		long MIN2 = 1000l;
		long MAX3 = -1l;

		for(int i = 0 ; i < N ; i++) {
			int _2cnt = 0; int _3cnt = 0;
			long now = arr[i];
			while(now % 3l == 0) {
				_3cnt++;
				now /= 3l;
			}
			now = arr[i];
			while(now % 2l == 0) {
				_2cnt++;
				now /= 2l;
			}

			if(MIN2 >= _2cnt && MAX3 <= _3cnt) {
				MIN2 = _2cnt; MAX3 = _3cnt;
				idx = i;
			}
		}
		ArrayList<Long> res = new ArrayList<>();
		long cnt = 0l;
		long now = arr[idx];
		res.add(now);
		while(cnt != (long)(N-1)) {
			if(now % 3l == 0 && hs.contains(now/3l)) {
				cnt++;
				now /= 3l;
				res.add(now);
			}else {
				cnt++;
				now *= 2l;
				res.add(now);
			}
		}
		for(long y : res) {
			System.out.print(y+ " ");
		}
	}

}

