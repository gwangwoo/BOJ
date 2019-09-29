package 백준2;

import java.util.Scanner;

public class 최단경로 {
	static int V;
	static int E;
	static int[][] W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		int s = sc.nextInt();
		W = new int[V][E];
		for(int i = 0 ; i < E ; i++) {
			W[sc.nextInt()-1][sc.nextInt()-1] = sc.nextInt();
		}
		
	}
}
