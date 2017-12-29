package 백준;
import java.util.*;
public class 부분집합의합2 {
	static int N;
	static int S;
	static int[] arr;
	static int count = 0;
	public static void go(int i , int sum) {
		if(i == N) {
			if(sum == S) {
				count+=1;
			}
			return;
		}
		go(i+1,sum+arr[i]);
		go(i+1,sum);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for(int i = 0 ; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		go(0,0);
		if(S == 0) count-=1;
		System.out.println(count);
	}
}
