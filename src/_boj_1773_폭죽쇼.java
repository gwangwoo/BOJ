import java.io.*;
import java.util.*;

public class _boj_1773_폭죽쇼 {
	static int N,C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		C = Integer.parseInt(st[1]);
		boolean check[] = new boolean[C+1];
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			int now = Integer.parseInt(br.readLine());
			for(int j = now ; j <= C ; j+= now) {
				if(!check[j]) {
					check[j] = true;
					res++;
				}
			}
		}
		System.out.println(res);
		
	}

}
