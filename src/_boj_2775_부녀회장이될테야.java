import java.io.*;
import java.util.*;

public class _boj_2775_부녀회장이될테야 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum[][] = new int[15][15];
		for(int i = 1 ; i < 15 ; i++) {
			sum[0][i] = i;
		}
		for(int i = 1 ; i < 15 ; i++) {
			sum[i][1] = 1;
		}
		for(int i = 1 ; i < 15 ; i++) {
			for(int j = 1 ; j < 15 ; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1];
			}
		}
		int T = Integer.parseInt(br.readLine());
		while(T-- >0 ) {
			int r = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			System.out.println(sum[r][c]);
		}
	}

}
