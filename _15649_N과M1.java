import java.io.*;
import java.util.*;

public class _15649_N과M1 {

	static int N,M;
	static int visited[];
	static void dfs(String str) {
		if(str.length() == M) {
			System.out.println(str);
			return;
		}
		for(int i = 1 ; i <= N ; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				String tmp = str;
				str += (i+ " ");
				dfs(str);
				visited[i] = 0;
				str = tmp;
				
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		M = M*2;
		visited = new int[N+1];
		dfs("");
	}

}
