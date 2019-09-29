package 백준;

import java.sql.Time;
import java.util.Scanner;

public class 소수구하기 {
	static int M;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check[] = new boolean[1000001];

		for (int i = 2; i <= 1000000; i++) {
			if (!check[i]) {
				for (int j = i + i; j <= 1000000; j += i)
					check[j] = true;
			}
		}
		M = sc.nextInt();
		N = sc.nextInt();
		for (int i = M; i <= N; i++)
			if (!check[i])
				System.out.println(i);
	}

}
