import java.io.*;
import java.util.*;

public class _boj_2444_별찍기7 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			// 빈칸 출력.
			for(int j = i ; j < N ; j++) {
				System.out.print(' ');;
			}
			for(int j = 0 ; j < 2*i-1 ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		for(int i = N-1 ; i >= 1 ; i--) {
			for(int j = N ; j > i ; j--) {
				System.out.print(' ');
			}
			for(int j = 0 ; j < 2*i-1 ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
	}

}
