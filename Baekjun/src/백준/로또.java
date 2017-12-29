package 백준;

import java.util.*;

public class 로또 {
	static int K;
	static String[] S;
	public static void go(String[] s2, int i, String str, int count) {
		if(count == 6) {
			System.out.println(str);
			return;
		}
		if(i>=s2.length) return;
		go(s2,i+1,str+s2[i],count+1);
		go(s2,i+1,str,count);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		while(K != 0) {
			S = new String[K];
			for(int i = 0 ; i < S.length; i++) {
				S[i] = sc.next();
			}
			int count = 0;
			go(S,0,"",count);
			System.out.println();
			K = sc.nextInt();
		}

	}

}


