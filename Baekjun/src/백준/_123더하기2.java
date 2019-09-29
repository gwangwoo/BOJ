package 백준;
import java.util.*;
public class _123더하기2 {
	public static int go(int count, int sum, int goal) {
		if(sum > goal) return 0;
		if(sum == goal) return 1;
		int now = 0;
		for(int i = 1; i<=3; i++) {
			now+= (go(count+1,sum+i,goal));
		}
		return now;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- >0) {
			int input = sc.nextInt();
			System.out.println(go(0,0,input));
			
		}
		
	}

}
