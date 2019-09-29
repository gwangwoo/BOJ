import java.io.*;
import java.util.*;

public class _boj_17174 {
	static int N,M;
	static int res;
	
	static void f(int n,int m) {
		res += (n/m * m);
		res += n%m;
		if(n/m >= m) f(n/m,m);
		else res += n/m;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		f(N,M);
		System.out.println(res);
	}

}
