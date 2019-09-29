import java.io.*;
import java.util.*;

public class _15651_N과M3 {
	static int N,M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int res[] = new int[8];

	static void dfs(int cnt) throws IOException {
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) {
				bw.write(res[i] + " ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			res[cnt] = i+1;
			dfs(cnt+1);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dfs(0);
	}

}
