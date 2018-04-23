package 새출발0415;

import java.util.*;

/*
 *  2018-04-23 월요일
 *  code by rhkddn5161
 * 
 */
public class 촌수계산_0423 {
	static ArrayList<Integer> arr[];
	static int check[];
	static int N;
	static int start,end;
	static int ans = 0;
	static void dfs(int v,int cnt) {
		if(v == end) {
			ans = cnt;
		}
		check[v] = 1;
		for(int y : arr[v]) {
			if(check[y] == 0) {
				dfs(y,cnt+1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		int T = sc.nextInt();
		arr = new ArrayList[N+1];
		check = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 1 ; i <= T ; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u].add(v);
			arr[v].add(u);
		}
			dfs(start,0);
		if(check[end] == 1) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}

	}

}
