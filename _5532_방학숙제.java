import java.util.Scanner;

public class _5532_방학숙제 {
	static int L,B,A;
	static int C,D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		
		int time = 0;
		while(true) {
			if(B <= 0 && A <= 0) break;
			B -= D;
			A -= C;
			time++;
		}
		System.out.println(L-time);
	}

}
