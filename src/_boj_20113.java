import java.io.*;
import java.util.*;

public class _boj_20113 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		int max = -1;
		for(int i = 0 ; i < N ; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[now]++;
			max = Math.max(max, arr[now]);
		}
		int res = 0;
		int idx = -1;
		for(int i = 1 ; i <= N ; i++) {
			if(arr[i] == max) {
				res++;
				idx = i;
			}
		}
		System.out.println(res==1?idx:"skipped");
	}
}