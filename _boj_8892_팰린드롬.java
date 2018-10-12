import java.util.*;

public class _boj_8892_ÆÓ¸°µå·Ò {
	static int N;
	static String[] arr;
	
	static boolean isPallin(String str) {
		int i = 0;
		int j = str.length()-1;
		for(; i < str.length()/2 ; i++, j--) {
			if(str.charAt(i) != str.charAt(j)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T  = sc.nextInt();
		NEXT:
		while(T-->0) {
			N = sc.nextInt();
			arr = new String[N];
			for(int i = 0 ; i < N ; i++) {
				arr[i] = sc.next();
			}
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(i == j) continue;
					String now = arr[i] + arr[j];
					if(isPallin(now)) {
						System.out.println(now);
						continue NEXT;
					}
				}
			}
			System.out.println(0);
		}
		
	}

}
