import java.io.*;
import java.util.*;

public class _boj_4796_캠핑 {
	static int L,P,V;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			if(L == 0 && P == 0 && V == 0) break;
			int res = 0;
			int cnt = V / P;
			int diff = V - P*cnt;
			res = cnt*L;
			if(diff >= L) {
				res += L;
			}else {
				res += diff;
			}
			System.out.println("Case "+num+++": "+res);
		}
	}
}
