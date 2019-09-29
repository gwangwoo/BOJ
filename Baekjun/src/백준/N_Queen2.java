package 백준;

import java.util.Scanner;

public class N_Queen2 {
	static boolean a[][] = new boolean[15][15];
	static boolean check_col[] = new boolean[15];
	static boolean check_dig[] = new boolean[30];
	static boolean check_dig2[] = new boolean[30];
	static int n;

	public static boolean check(int row,int col) {
		// | 검사
		if(check_col[col]) return false;
		// 오른쪽 위 검사
		if(check_dig[row+col]) return false;
		if(check_dig2[row-col+n]) return false;
		return true;
	}
	public static int calc(int row) {
		if(row == n) {
			return 1;
		}
		int cnt = 0;
		for(int col = 0 ; col < n ; col++) {
			if(check(row,col)) {
				check_col[col] = true;
				check_dig[row+col] = true;
				check_dig2[row-col+n] = true;
				a[row][col] = true;
				cnt = cnt + calc(row+1);
				check_col[col] = false;
				check_dig[row+col] = false;
				check_dig2[row-col+n] = false;
				a[row][col] = false;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(calc(0));
	}

}
