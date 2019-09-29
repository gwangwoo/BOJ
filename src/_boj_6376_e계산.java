
public class _boj_6376_e계산 {

	public static void main(String[] args) {
		System.out.println("n e");
		System.out.println("- -----------");
		for(int n = 0 ; n <= 9 ; n++) {
			System.out.print(n + " ");
			double e = 1d;
			for(int i = 1 ; i <= n ; i++) {
				double mo = 1;
				for(int j = i ; j > 0 ; j--) {
					mo *= j;
				}
				e += 1d/mo;
			}
			if(e <= 2.0) {
				System.out.print((int)e);
				System.out.println();
				continue;
			}else if(e == 2.5) {
				System.out.print(e);
				System.out.println();
				continue;
			}
			System.out.printf("%.9f",e);
			System.out.println();
		}
	}

}
