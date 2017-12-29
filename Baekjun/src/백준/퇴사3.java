package 백준;

import java.util.*;

public class 퇴사3 {
	static int T[];
	static int P[];
	static int res;
	static int t;
	static int m;

	public static void dfs(int[] T, int[] P, int i, int sum) {
		if (i  <= t+ 1)							// 마지막날 1일 일 경우 포함
			res = Math.max(sum, res);		
		if (i > t)								// t일을 넘었을때 죽여
			return;

		dfs(T, P, i + 1, sum);					// T[i]를 선택안한경우
		dfs(T, P, i + T[i], sum + P[i]);		// T[i]를 선택 한 경우, sum 에도 P[i] 를 더해서 대꼬가기

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