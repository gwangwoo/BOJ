package 백준;


import java.util.Scanner;

public class 다음순열구하기 {
	public static boolean next_permutation(int [] a) {
		int i = a.length -1;
		while(i > 0 && a[i-1] >= a[i]) {
			i = i- 1;
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
			tmp = a[j];
			a[j] = a[i];
			a[i] = tmp;
			i = i+1;
			j = j-1;
		}


		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int [] a = new int[T];
		for(int i = 0; i < T ; i++) {
			a[i] = sc.nextInt();
		}
		if(next_permutation(a)) {
			for(int i = 0; i < T ; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}else {
			System.out.println("-1");
		}
	}

}
