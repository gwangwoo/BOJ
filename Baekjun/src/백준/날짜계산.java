package 백준;

import java.util.Scanner;

public class 날짜계산 {
	public static void main(String args[]) {
		int E, S, M;
		Scanner sc = new Scanner(System.in);
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		int e = 1,s = 1,m=1; 
		for(int i = 1; ; i++) {
			if( e == E && s == S && m == M) {
				System.out.println(i);
				break;
			}
			e = e+1;
			s = s+1;
			m = m+1;
			if( e == 16) {
				e = 1;
			}
			if(s == 29) {
				s = 1;
			}
			if(m == 20) {
				m = 1;
			}
		}
	}
}
