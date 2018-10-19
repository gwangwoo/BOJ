import java.io.*;
import java.util.*;

public class _boj_15664_N과M10 {
	static int N,M;
	static int arr[];
	static int res[];
	static void dfs(int index , String str) throws IOException {
		if(index == M) {
			for(int i = 0 ; i < M-1 ; i++) {
				if(res[i] > res[i+1]) return;
			}
			bw.write(str+ "\n");
			return;
		}
		
		for(int i = 0 ; i < 10001 ; i++) {
			if(arr[i] > 0) {
				arr[i]--;
				res[index] = i;
				dfs(index+1, str+i+" " );
				arr[i]++;
			}
		}
	}

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[10001];
		res = new int[M];
		for(int i = 0 ; i < N ; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		dfs(0,"");
		bw.flush();
	}

}
