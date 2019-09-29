import java.io.*;
import java.util.*;
public class _boj_15665 {
	static int N,M;
	static int arr[];
	static int res[];
	static boolean visited[] = new boolean[10001];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static boolean isPossible() {
		for(int i = 0 ; i < M-1 ; i++) {
			if(res[i] > res[i+1]) return false;
		}
		return true;
	}
	
	static void dfs(int cnt,String str) throws IOException{
		if(cnt == M) {
			if(isPossible()) {
				bw.write(str+ "\n");
			}
			return;
		}

		for(int i = 0 ;  i < N ; i++) {
			res[cnt] = arr[i];
			dfs(cnt+1,str+arr[i]+" ");
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		int cnt2 = 0;
		for(int i = 0 ; i < N ; i++) {
			int val = Integer.parseInt(st.nextToken());
			if(!visited[val]) {
				visited[val] = true;
				cnt2++;
			}
		}
		arr = new int[cnt2];
		res = new int[M];
		for(int i = 1 ; i < 10001 ; i++) {
			if(visited[i]) {
				arr[cnt++] = i;
			}
		}
		N = cnt;
		Arrays.parallelSort(arr);
		dfs(0,"");
		bw.flush();
	}
}
