import java.io.*;
import java.util.*;
public class _boj_14719 {
	static int H,W;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < W ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for(int i = 1 ; i < W-1 ; i++) {
			int left_h = 0,right_h = 0;
			int now = i;
			while(--now >= 0) left_h = Math.max(left_h, arr[now]);
			now = i;
			while(++now < W) right_h = Math.max(right_h, arr[now]);
			int min = Math.min(left_h, right_h);
			if(min-arr[i] < 0) continue;
			ans += min-arr[i];
		}
		System.out.println(ans);
		
	}

}
