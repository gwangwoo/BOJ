import java.io.*;
import java.util.*;

public class _boj_10819_차이를최대로 {
	static int N;
	static int arr[];
	static int res;
	static boolean visited[];
	
	static void dfs(int prev,int cnt, int sum) {
		if(cnt == N) {
			res = Math.max(res, sum);
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(i,cnt+1, sum+Math.abs(arr[prev] - arr[i]));
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		for(int i = 0 ; i < N ; i++) {
			visited[i] = true;
			dfs(i,1,0);
			visited[i] = false;
		}
		System.out.println(res);
		
		
	}

}
