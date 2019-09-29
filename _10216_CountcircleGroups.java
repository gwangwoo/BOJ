import java.io.*;
import java.util.*;

public class _10216_CountcircleGroups {
	static int N;
	static Point camp[];
	static ArrayList<Integer> adj[]; 
	static boolean visited[];
	
	static void dfs(int start) {
		visited[start] = true;
		for(int y : adj[start]) {
			if(!visited[y]) dfs(y);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- >0) {
			N = Integer.parseInt(br.readLine());
			adj = new ArrayList[N];
			for(int i = 0 ; i < N ; i++) {
				adj[i] = new ArrayList<>();
			}
			camp = new Point[N];
			visited = new boolean[N];
			for(int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				camp[i] = new Point(x,y,r);
			}
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(i == j) continue;
					int x = Math.abs(camp[i].x - camp[j].x);
					int y = Math.abs(camp[i].y - camp[j].y);
					double r = (double)camp[i].r + (double)camp[j].r;
					double d = Math.sqrt(x*x + y*y);
					if(d <= r) {
						adj[i].add(j);
					}
				}
			}
			int cnt = 0;
			for(int i = 0 ; i < N ; i++) {
				if(!visited[i]) {
					dfs(i);
					cnt++;
				}
			}
			System.out.println(cnt);
			
		}
		
	}
	static class Point {
		int x,y,r;
		Point(int x,int y,int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
}
