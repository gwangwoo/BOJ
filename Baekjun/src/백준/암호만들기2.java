package 백준;

import java.util.*;
public class 암호만들기2 {
	public static void go(int n, String[] alpha, String password, int i) {
		if(n == password.length()) {
			if(check(password)) {
				System.out.println(password);
			}
			return;
		}
		if(i >= alpha.length) return;
		go(n,alpha,password+alpha[i],i+1);
		go(n,alpha,password,i+1);
	}
	public static boolean check(String password) {
		int ja = 0;
		int mo = 0;
		for(char x:password.toCharArray()) {
			if(x=='a' || x=='e' || x=='i' || x=='o' ||x=='u') mo+=1;
			else {
				ja+=1;
			}
		}
		return mo>=1 && ja>=2;
				// 1개의 모음과 최소 2개의 자음
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int C = sc.nextInt();
		sc.nextLine();
		String[] alpha = sc.nextLine().split(" ");
		Arrays.sort(alpha);
		go(L,alpha,"",0);
	}
}