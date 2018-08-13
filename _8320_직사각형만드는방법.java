import java.util.*;

public class _8320_직사각형만드는방법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = 0;
		for(int i = 1; i <= N ; i++) {
			for(int j = i ; i*j <= N ; j++) {
				r++;
			}
		}
		System.out.println(r);
	}
}
