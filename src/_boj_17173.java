import java.io.*;
import java.util.*;

public class _boj_17173 {
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int res = 0;
		boolean check[] = new boolean[1001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			int now = Integer.parseInt(st.nextToken());
			for(int j = now ; j <= N ; j+= now) {
				if(!check[j]) {
					res += j;
					check[j] = true;
				}
				else continue;
//				System.out.println(j + " " + res);
			}
		}
		System.out.println(res);
		
	}

}
