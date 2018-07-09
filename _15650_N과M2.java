import java.io.*;
import java.util.*;

public class _15650_N과M2 {
	static int N,M;
	static boolean check[] = new boolean[9];
	static int res[] = new int[9];

	static void dfs(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M-1 ; i++) {
				if(res[i] >= res[i+1]) return;
			}
			for(int i = 0; i < M ; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i = 1 ; i <= N ; i++) {
			if(!check[i]) {
				check[i] = true;
				res[cnt]= i;
				dfs(cnt+1);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dfs(0);

	}
}
