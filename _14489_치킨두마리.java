import java.util.*;

public class _14489_치킨두마리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		
		if(A+B >= 2*C) {
			long tmp = A+B - 2*C;
			System.out.println(tmp);
		}else {
			long tmp = A+B;
			System.out.println(tmp);
		}
		
	}

}
