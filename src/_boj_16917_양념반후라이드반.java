import java.io.*;
import java.util.*;

public class _boj_16917_양념반후라이드반 {
	static long A,B,C,X,Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());
		
		C *=2;
		long min = Integer.MAX_VALUE;
		long sum = 0;
		// 반반
		for(int i = 0 ; i < X+Y ; i++) {
			if(X-i < 0 || Y-i < 0) break;
			sum = (X-i)*A + (Y-i)* B + i*C;
			min = Math.min(min, sum);
		}
		long MAX = X > Y ? X:Y;
		min = Math.min(min, MAX*C);
		System.out.println(min);
	}
}
