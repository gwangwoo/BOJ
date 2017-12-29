package 백준;

import java.util.Scanner;

public class 몸풀기_AB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if(A == 0 && B == 0) {
				break;
			}
			System.out.println(A+B);
		}
	}

}
