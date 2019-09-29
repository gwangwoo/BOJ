import java.io.*;
import java.util.*;
public class _boj_15649 {
	static int N,M;
	static int arr[];
	static int res[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static boolean isPossible() {
		for(int i = 1 ; i < M ; i++) {
			if(res[i-1] > res[i]) return false;
		}
		return true;
	}
	
	static void dfs(int cnt) throws IOException{
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) bw.write(res[i] + " ");
			bw.write("\n");
			return;
		}
		
		for(int i = 0 ; i < 10001 ; i++) {
			if(arr[i] <= 0) continue;
			arr[i]--;
			res[cnt] = i;
			dfs(cnt+1);
			arr[i]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[10001];
		res = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) arr[Integer.parseInt(st.nextToken())]++;
//		Arrays.parallelSort(arr);
		dfs(0);
		bw.flush();
	}

}
