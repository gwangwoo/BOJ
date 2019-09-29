package น้มุ2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dfs_bfs {
	static int n,m,s;
//	static int arr[][];
//	static boolean check[];
	static void dfs(int[][] a , boolean[] c, int v) {
		if(c[v] == true) {
			return;
		}
		int N = a.length - 1;
		c[v] = true;
		System.out.print(v + " ");
		for(int i = 1; i <=N ; i++) {
			if(a[v][i] == 1 && c[i] == false) {
				dfs(a,c,i);
			}
		}
	}
	static void bfs(int[][] a , boolean[] c, int v) {
		Queue<Integer> q = new LinkedList<>();
		int N = a.length-1;
		q.add(v);
		c[v] = true;
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");

			for(int i = 1 ; i <=N ; i++) {
				if(a[v][i] == 1 && c[i] == false) {
					c[i] = true; 
					q.add(i);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		s = sc.nextInt();

		int arr[][] = new int[n+1][n+1];
		boolean check[] = new boolean[n+1];

		for(int i = 0 ; i < m ;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u][v] = 1;
			arr[v][u] = 1;
		}
		dfs(arr,check,s);
		Arrays.fill(check,false);
		System.out.println();
		bfs(arr,check,s);
	}
}
