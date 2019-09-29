import java.util.*;
import java.io.*;

public class _boj_15654_N과M5 {
	static int N,M;
	static int arr[];
	static int check[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dfs(int index , String str) throws IOException{
		if(index == M) {
			bw.write(str+"\n");
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(check[i] == 1) continue;
			check[i] = 1;
			dfs(index+1,str+arr[i]+" ");
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
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0,"");
		bw.flush();
	}

}
