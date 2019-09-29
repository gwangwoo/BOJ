package 백준2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dfs_bfs2 { // 인접 행렬을 사용하여 풀이.
	static int n,m;
	static int arr[][];
	static boolean check[];
	
	static void dfs(int v) {
		if(check[v] == true)
			return;
		check[v] = true;
		System.out.print(v + " ");
		for(int i = 1; i <=n ; i++) {
			if(arr[v][i] == 1 && check[i] == false) {
				dfs(i);
			}
		}
	}
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		check[v] = true;
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");
			for(int i = 1; i <= n; i++) {
				if(arr[v][i] == 1 && check[i] == false) {
					check[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int s = sc.nextInt();
		
		arr = new int[n+1][n+1];
		check = new boolean[n+1];
		
		for(int i = 0 ; i < m ; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			arr[u][v] = arr[v][u] = 1;
		}
		dfs(s);
		Arrays.fill(check, false);
		System.out.println();
		bfs(s);
	}
}
