import java.util.*;
import java.io.*;

public class _boj_15655_N과M6 {
	static int N,M;
	static int arr[];
	static int check[];
	static int res[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dfs(int index, String str) throws IOException {
		if(index == M) {
			for(int i = 0 ; i < M-1 ; i++) {
				if(res[i] >= res[i+1]) return;
			}
			bw.write(str+"\n");
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(check[i] == 1) continue;
			check[i] = 1;
			res[index] = i+1;
			dfs(index+1 , str+arr[i]+ " ");
			check[i] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		check = new int[N];
		res = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0,"");
		bw.flush();	
		
	}

}
