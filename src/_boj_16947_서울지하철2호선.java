import java.io.*;
import java.util.*;

public class _boj_16947_서울지하철2호선 {
	static int N;
	static int visited[];
	static ArrayList<Integer> arr[];
	
	static int dfs(int idx, int prev) {
		visited[idx] = -1;
		for(int y : arr[idx]) {
			if(visited[y] == 0) {
				int val = dfs(y,idx);
				if(val == -3) return -1;
				visited[y] = 2;
				if(val == idx) {
					visited[idx] = 2;
					return 2 ;
				}
				else return val;
			}else if(prev == y) {
				continue;
			}else if(visited[y] == -1) {
				return y;
			}
		}
		return -3;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) arr[i] = new ArrayList<>();
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		visited = new int[N+1];
		// cycle 해주기.
		dfs(1,-1);
		for(int i = 1 ; i <= N ; i++) {
			System.out.print(visited[i] + " ");
		}
	}

}
