import java.util.*;
import java.io.*;

public class _boj_1535_안녕 {
	static int N;
	static int L[],J[];
	static int res;
	
	static void dfs(int index, int happy, int hp) {
		if(hp <= 0) return;
		if(index == N) {
			res = Math.max(res, happy);
			return;
		}
		dfs(index+1,happy+J[index],hp-L[index]);
		dfs(index+1,happy,hp);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		L = new int[N];
		J = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) L[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) J[i] = Integer.parseInt(st.nextToken());
		
		dfs(0,0,100);
		System.out.println(res);
	}

}
