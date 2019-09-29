//package 실습과제;


import java.util.Scanner;


public class WordCalculation {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String a = new String();
		int score=0;

		while(score!=100) {

			System.out.print("Enter a word:");

			a=input.next().toUpperCase();

			System.out.println("The value of the word"+a+"="+score);

			for(int i=0;i<a.length();i++) {

				score+=a.charAt(i)-'A'+1;

			}

			if(score>=0 && score!=100) {

				System.out.println(score);

				score=0;

			}

		}

	}

}

