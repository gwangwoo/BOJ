import java.util.*;
import java.io.*;

public class _boj_15663_N과M9 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,M;
	static int arr[];
	
	static void dfs(int index, String str) throws IOException{
		if(index == M) {
			bw.write(str+ "\n");
			return;
		}
		for(int i = 0 ; i < 10001 ; i++) {
			if(arr[i] <= 0) continue;
			arr[i]--;
			dfs(index+1, str+ i+ " ");
			arr[i]++;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[10001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		dfs(0,"");
		bw.flush();
	}

}
