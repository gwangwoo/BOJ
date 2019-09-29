import java.util.*;

public class _11970_페인팅 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,c,d;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		if((a >= c && a <= d) || (b >= c && b <= d) || (c >= a && c <= b) || (d >= a && d <= b)) {
			int bottom = Math.min(a, c);
			int top = Math.max(b, d);
			int res = top - bottom;
			System.out.println(res);
		}else {
			int res = (b-a) + (d-c);
			System.out.println(res);
		}
		
		
		
	}

}
