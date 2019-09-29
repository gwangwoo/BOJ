import java.io.*;
import java.util.*;

public class _boj_16953_AB {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int res = 1;
		while(B >= A) {
			if(A == B) {
				System.out.println(res);
				return;
			}
			if(B % 10 == 1) B /= 10;
			else if(B % 2 == 0) B /= 2;
			else {
				System.out.println(-1);
				return;
			}
			res++;
		}
		System.out.println(-1);
	}

}
