import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class _boj_14717 {

	public static void main(String[] args) throws IOException{
		DecimalFormat df = new DecimalFormat("0.000");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = 153;
		int res = 0;
		boolean flag = false;
		if(A == B) flag = true;
		if(flag) {
			res = N - (10 - A);
			System.out.println(df.format((double)res/N * 1.0));
		}else {
			int val = (A+B) % 10;
			for(int i = 1 ; i <= 10 ; i++) {
				for(int j = i+1 ; j <= 10 ; j++) {
					int sum = i+j;
					if(sum % 10 < val) {
						if(i == A || i == B || j == A || j == B) {
							res += 2;
						}else res += 4;
					}
				}
			}
			System.out.println(df.format((double)res / N));
		}

	}
}
