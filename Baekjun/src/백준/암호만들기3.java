/*package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기3 {
	static int L;
	static int C;
	static char alpha[];
	public static void go(String[] str,String password,int i) {
		if(L == password.length()) {
			if(check(password)) {
				System.out.println(password);
			}
			return;
		}
		go(str,password+str[i],i+1);
		go(str,password,i+1);
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		L= sc.nextInt();
		C = sc.nextInt();
		String[] str = sc.nextLine().split(" ");
		Arrays.sort(str);
		go(str,"",0);
	}

}
*/