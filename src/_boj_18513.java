import java.util.*;
import java.io.*;

public class _boj_18513 {
	static int N,K;
	static int map[];
	static int dc[] = {-1,1};
	static HashSet<Integer> visited = new HashSet<>();
	static Queue<Point> q = new LinkedList<>();

	static long bfs() {
		long res = 0;
		
		while(K != 0) {
			Point p = q.poll();
			int c = p.c;
			int cnt = p.cnt;
			
			for(int k = 0 ; k < 2 ; k++) {
				int nc = c + dc[k];
				
				if(nc < 0 || nc > 200_000_000) continue;
				if(visited.contains(nc)) continue;
				visited.add(nc);
				q.add(new Point(nc,cnt+1));
				res += (cnt+1);
				K--;
				if(K == 0) break;
			}
		}
		return res;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int now = Integer.parseInt(st.nextToken()) + 100_000_000;
			q.add(new Point(now, 0));
			visited.add(now);
		}
		
		System.out.println(bfs());
		
	}
	static class Point {
		int c,cnt;
		Point(int c, int cnt) {
			this.c = c;
			this.cnt = cnt;
		}
	}
}
