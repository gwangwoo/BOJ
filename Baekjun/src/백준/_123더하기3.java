package 백준;

import java.util.*;

public class _123더하기3 {
	public static int go(int count, int sum, int goal) {
		if(goal == sum) return 1;
		if(goal < sum) return 0;
		int now = 0;
		for(int i = 1 ; i <= 3 ; i++) {
			now = now + go(count+i,sum+i,goal);
		}
		return now;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			System.out.println(go(0,0,n));
		}
	}
}
