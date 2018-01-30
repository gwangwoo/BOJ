package 백준2;

import java.util.Scanner;

public class 연결요소의개수 {
	static int n,m;
	static int[][] arr;
	static boolean check[];
	
	static void dfs(int v) {
		if(check[v] == true)
			return;
		check[v] = true;
		for(int i=1; i<=n ;i++) {
			if(arr[v][i] == 1 && check[i] == false) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1][n+1];
		check = new boolean[n+1];
		
		for(int i = 0 ; i < m ; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			arr[u][v] = arr[v][u] = 1;
		}
		int ans = 0;
		for(int i=1; i<=n; i++) {
			if(check[i] == false) {
				dfs(i);
				ans+=1;
			}
		}
		System.out.println(ans);
	}
}
