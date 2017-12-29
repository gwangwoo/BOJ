package 백준;
import java.util.*;
public class 더하기사이클 {
	static int count = 0;
	static int first,second;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int real = T;
		if(T < 10) {
			first = 0 ;
			second = T;
			T = first + second;
		}
		while(true) {
			first = T/10;
			second = T%10;
			T = (second*10)+(first + second)%10;
			count++;
			if(real == T) break;
		}
		System.out.println(count);
	}
}
