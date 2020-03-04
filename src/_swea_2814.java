import java.io.*;
import java.util.*;
public class _swea_2814 {
	static int N,M;
	static ArrayList<Integer> arl[];
	static int MAX;
	
	static void dfs(boolean visited[],int cnt,int v) {
		visited[v] = true;
		for(int y : arl[v]) {
			if(visited[y]) continue;
			dfs(visited,cnt+1,y);
			visited[y] = false;
		}
		if(cnt > MAX) MAX = cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			MAX = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(M == 0) {
				System.out.println("#"+tc + " " + 1);
				continue;
			}else if(M == 1) {
				System.out.println("#"+tc + " " + 2);
				continue;
			}else {
				arl = new ArrayList[N+1];
				for(int i = 1 ; i <= N ; i++) {
					arl[i] = new ArrayList<>();
				}
				for(int i = 0 ; i < M ; i++) {
					st = new StringTokenizer(br.readLine());
					int u = Integer.parseInt(st.nextToken());
					int v = Integer.parseInt(st.nextToken());
					arl[u].add(v);
					arl[v].add(u);
				}
				int res = 0;
				for(int i= 1 ; i <= N ; i++) {
					boolean visited[] = new boolean[N+1];
					dfs(visited,1,i);
				}
				System.out.println("#"+tc + " " + MAX);
			}
		}
	}
}
