package ����;

import java.util.*;

public class ���3 {
	static int T[];
	static int P[];
	static int res;
	static int t;
	static int m;

	public static void dfs(int[] T, int[] P, int i, int sum) {
		if (i  <= t+ 1)							// �������� 1�� �� ��� ����
			res = Math.max(sum, res);		
		if (i > t)								// t���� �Ѿ����� �׿�
			return;

		dfs(T, P, i + 1, sum);					// T[i]�� ���þ��Ѱ��
		dfs(T, P, i + T[i], sum + P[i]);		// T[i]�� ���� �� ���, sum ���� P[i] �� ���ؼ� �벿����

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		T = new int[17];
		P = new int[17];
		for (int i = 1; i <= t; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		dfs(T, P, 1, 0);
		System.out.println(res);

	}
}