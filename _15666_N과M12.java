import java.io.*;
import java.util.*;

public class _15666_N과M12 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int remain[] = new int[100001];
	static int N,M;
	static int res[] = new int[8];
	static ArrayList<Integer> arr = new ArrayList<>();
	
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
		for(int i = 0 ; i < arr.size(); i++) {
			if(remain[arr.get(i)] > 0) {
				res[cnt] = arr.get(i);
				dfs(cnt+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			remain[Integer.parseInt(st.nextToken())]++;
		}
		for(int i = 0 ; i < 10001 ; i++) {
			if(remain[i] > 0) {
				arr.add(i);
			}
		}
		dfs(0);
	}
}
