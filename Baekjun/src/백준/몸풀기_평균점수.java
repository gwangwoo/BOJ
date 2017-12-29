package ¹éÁØ;

import java.util.Scanner;

public class ¸öÇ®±â_Æò±ÕÁ¡¼ö {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 5;
		int sum = 0;
		while(T-- >0) {
			int score = sc.nextInt();
			if(score < 40) score = 40;
			sum = sum + score;
		}
		System.out.println(sum/5);
	}

}
