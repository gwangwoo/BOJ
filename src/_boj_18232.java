import java.io.*;
import java.util.*;
public class _boj_18232 {
	static int N,M;
	static int map[];
	static int S,E;
	static ArrayList<Integer> arl[];
	static int dc[] = {-1,1};
	
	static int bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean visited[] = new boolean[N+1];
		q.add(new Point(S,0));
		visited[S] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int now = p.now;
			int cnt = p.cnt;
			
			if(now == E) return cnt;
			for(int k = 0 ; k < 2 ; k++) {
				int nc = now + dc[k];
				if(nc <= 0 || nc > N) continue;
				if(visited[nc]) continue;
				
				q.add(new Point(nc,cnt+1));
				visited[nc] = true;
			}
			if(arl[now].size() != 0) {
				for(int y : arl[now]) {
					if(visited[y]) continue;
					q.add(new Point(y,cnt+1));
					visited[y] = true;
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1];
		arl = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) arl[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arl[u].add(v);
			arl[v].add(u);
		}
		System.out.println(bfs());
	}
	static class Point {
		int now,cnt;
		Point(int now, int cnt) {
			this.now = now;
			this.cnt = cnt;
		}
	}
}
