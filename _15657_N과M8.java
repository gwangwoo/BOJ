import java.io.*;
import java.util.*;

public class _15657_N과M8 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int arr[];
	static int res[] = new int[8];
	static int N,M;
	
	static void dfs(int cnt) throws IOException {
		if(cnt == M) {
			for(int i = 0 ; i < M-1 ; i++) {
				if(res[i] > res[i+1]) return;
			}
			for(int i = 0 ; i < M ; i++) {
				bw.write(res[i] + " ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			res[cnt] = arr[i];
			dfs(cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0);
		
	}

}
