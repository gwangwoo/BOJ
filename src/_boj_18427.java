import java.io.*;
import java.util.*;
public class _boj_18427 {
	static int N,K;
	static int arr[];
	static boolean visited[];
	static int res;
	
	static boolean check(String str) {
		int def = 500;
		int n = str.length();
		for(int i = 0 ; i < n ; i++) {
			int idx = str.charAt(i)-'0';
			def += arr[idx] - K;
			if(def < 500) return false;
		}
		return true;
	}
	
	static void dfs(int idx, String str) {
		if(idx == N) {
			if(check(str)) {
				res++;
			}
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(idx+1, str+i+"");
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,"");
		System.out.println(res);
	}
}