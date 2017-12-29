package ����;

import java.sql.Time;
import java.util.Scanner;

public class �����佺�׳׽�ü {
	static int N;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check[] = new boolean[1000001];

		for (int i = 2; i <= 1000000; i++) {
			if (!check[i]) {
				for (int j = i + i; j <= 1000000; j += i)
					check[j] = true;
			}
		}
		N = sc.nextInt();
		K = sc.nextInt();
		for (int i = N; i <= K; i++)
			if (!check[i])
				System.out.println(i);
	}

}
