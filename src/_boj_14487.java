import java.io.*;
import java.util.*;
public class _boj_14487 {
	static int N,sum,max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int val = Integer.parseInt(st.nextToken());
			sum += val;
			max = Math.max(max, val);
		}
		System.out.println(sum - max);
	}
}
