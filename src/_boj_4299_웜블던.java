import java.util.*;

public class _boj_4299_웜블던 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int s = sc.nextInt();
		 int d = sc.nextInt();
		 if((s+d)%2 == 1) {
			 System.out.println(-1);
			 return;
		 }
		 int a = (s+d)/2; int b = (s-d)/2;
		 if(a < 0 || b < 0) System.out.println(-1);
		 else System.out.println(Math.max(a, b) + " " + Math.min(a, b));
	}

}
