import java.io.*;
import java.util.*;

public class _boj_10833_사과 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int apple = Integer.parseInt(st.nextToken());
			int mul = apple / num;
			res += apple - (num * mul);
		}
		System.out.println(res);
	}

}
