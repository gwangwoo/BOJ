package 백준;

import java.util.Scanner;

public class 모든순열 {
	static int[] a;
	public static boolean next(int[] a) {
		int i = a.length - 1;
		while(i > 0 && a[i-1] >= a[i]) {
			i = i -1;
		}
		if(i <= 0) {
			return false;
		}
		int j = a.length -1;
		while(a[j] <= a[i-1]) {
			j = j-1;
		}
		int tmp = a[i-1];
		a[i-1] = a[j];
		a[j] = tmp;
		
		j = a.length -1;
		while(i < j) {
			tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			i = i +1;
			j = j -1;
		}
		return true;
	}
	public static int pact(int t) {
		if(t <= 1) {
			return 1;
		}else {
			return t * pact(t-1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		a = new int[T];
		int count = pact(T) - 1;
		for(int i = 1 ; i <= T ; i++) {
			a[i-1] = i;
			System.out.print(i + " ");
		}
		System.out.println();
		while(count-- != 0) {
			if(next(a)) {
				for(int i = 0 ; i < T ; i++) {
					System.out.print(a[i] + " ");
				}
				System.out.println();
			}else {
				System.out.println("-1");
			}
		}
	}
}

