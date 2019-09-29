import java.io.*;
import java.util.*;
public class _boj_15664 {
	static int N,M;
	static int arr[] = new int[10001];
	static int res[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static boolean isPossible() {
		for(int i = 0 ; i < M-1 ; i++) {
			if(res[i] > res[i+1]) return false;
		}
		return true;
	}
	static void dfs(int cnt) throws IOException{
		if(cnt == M) {
			if(isPossible()) {
				for(int i = 0 ; i < M ; i++) bw.write(res[i]+ " ");
				bw.write("\n");
			}
			return;
		}
		
		for(int i = 1 ;  i < 10001 ; i++) {
			if(arr[i] > 0) {
				arr[i]--;
				res[cnt] = i;
				dfs(cnt+1);
				arr[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) arr[Integer.parseInt(st.nextToken())]++;
		dfs(0);
		bw.flush();
	}

}
