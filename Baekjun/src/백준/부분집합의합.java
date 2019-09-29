package 백준;
import java.util.*;
public class 부분집합의합 {
	static int[] arr;
	static int N;
	static int S;
	static int count = 0;
	
	
	public static void go(int sum, int i) {
		if(i == N) {
			if(sum == S) {
				count += 1;
				System.out.println(sum + " " + i);
			}
			return;
		}
		go(sum+arr[i],i+1);
		go(sum,i+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for(int i = 0 ;i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		go(0,0);
		if(S == 0) count-=1;
		System.out.println(count);
	}

}
