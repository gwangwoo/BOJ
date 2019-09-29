import java.io.*;
import java.util.*;

public class _boj_2292_벌집 {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 1;
		int ans = 1;
		int mul = 6;
		while(res < N) {
			res += mul;
			ans++;
			mul+= 6;
		}
		System.out.println(ans);
	}

}
