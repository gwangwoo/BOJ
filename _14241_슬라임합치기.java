import java.util.*;
import java.io.*;

public class _14241_슬라임합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp = Integer.parseInt(st.nextToken());
		int sum = tmp;
		int res = tmp;
		int op = 0;
		for(int i = 0 ; i < N-1 ; i++) {
			int tmp2 = Integer.parseInt(st.nextToken());
			op += res*tmp2;
			sum+= tmp2;
			res = sum;
		}
		System.out.println(op);
	}

}
