import java.io.*;
import java.util.*;

public class _boj_16938_캠프준비 {
	static int N,L,R,X;
	static int arr[];
	static int res;
	
	static void dfs(int cnt,int index, int sum, int min , int max) {
		if(index == N) {
			if(cnt >= 2 && sum >= L && sum <= R && Math.abs(max-min) >= X) {
				res++;
			}
			return;
		}
		int val = arr[index];
		// 한다 안한다.
		dfs(cnt+1 , index+1 , sum + val , Math.min(val, min) , Math.max(val, max));
		dfs(cnt , index+1 , sum , min , max);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0,0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		System.out.println(res);
	}

}
