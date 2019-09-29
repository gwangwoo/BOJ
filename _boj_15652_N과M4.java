import java.io.*;
import java.util.*;

public class _boj_15652_N과M4 {
	static int N,M;
	static int arr[];
	static int res[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void dfs(int index, String str) throws IOException{
		if(index == M) {
			for(int i = 0 ; i < M-1 ; i++) {
				if(res[i] > res[i+1]) return;
			}
			bw.write(str+"\n");
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			res[index] = i+1;
			dfs(index+1, str+arr[i]+ " ");
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[M];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = i+1;
		}
		dfs(0,"");
		bw.flush();
		
	}

}
