package น้มุ;

import java.util.Arrays;
import java.util.Scanner;

public class ล๐ป็2 {
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
		
	}
}
