package ����;

import java.util.*;

public class ��� {
	static int T[] = new int[16];
	static int P[] = new int[16];
	static int check[] = new int[16];
	static int sum = 0;
	static int max = 0;
	static int N;
	static final int INF = 10000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		Arrays.fill(check, -1); 
		System.out.println(dfs(0));
	}

	public static int dfs(int i) {
		if(i == N) return 0;
		if(i > N) return -INF; // �̺κ� �����ϱ�
		if(check[i]!= -1) return check[i];
		
		return check[i] = Math.max(dfs(i+1), dfs(i+T[i])+ P[i]);
		 //dp[x] = x���� ���� ���� ���, x���� ���� �ϰ� T[x]�� ���� ���� �� ��� �� �ִ� �� ����
	}
}
