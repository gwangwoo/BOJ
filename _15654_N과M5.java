import java.util.*;
import java.io.*;

public class _15654_N과M5 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean check[] = new boolean[8];
	static int res[] = new int[8];
	static int arr[];
	static int N,M;
	
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
			if(!check[i]) {
				check[i] = true;
				res[cnt] = arr[i];
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
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0);
	}

}
