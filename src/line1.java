import java.util.*;

public class line1 {
	static long N,w,h;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		long res = (long)1e13;
		for(long i = 1 ; i*i <= N ; i++) {
			w = i; h = N/i;
			if(w*h == N) {
				res = (long)(Math.min(w, h-w));
			}
		}
		System.out.println(res);
	
	
	}

}
