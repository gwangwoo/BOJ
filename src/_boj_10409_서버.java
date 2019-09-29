import java.io.*;
import java.util.*;

public class _boj_10409_서버 {
	static int N,T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int size = st.countTokens();
		int res = 0;
		while(size-- > 0) {
			int task = Integer.parseInt(st.nextToken());
			T -= task;
			if(T < 0) break;
			res++;
		}
		System.out.println(res);
		
	}

}
