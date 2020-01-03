import java.io.*;
import java.util.*;

public class _boj_18235 {
	static int N,A,B;
	static int ori[];
	static int yri[];
	static int dc[] = {-1,1};
	static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(A,0,true));
		q.add(new Point(B,0,false));
		while(!q.isEmpty()) {
			int q_size = q.size();
			while(q_size-- > 0) {
				Point p = q.poll();
				int now = p.now;
				int cnt = p.cnt;
				boolean flag = p.flag;

				for(int k = 0 ; k < 2 ; k++) {
					int nc = now + (dc[k] * (1 << cnt));
					if(nc <= 0 || nc > N) continue;
					if(flag) {
						ori[nc] = cnt+1;
						q.add(new Point(nc,cnt+1,flag));
					}else {
						yri[nc] = cnt+1;
						q.add(new Point(nc,cnt+1,flag));
					}
				}
			}
			for(int i = 1 ; i <= N ; i++) {
				if(ori[i] == yri[i] && ori[i] != 0) return ori[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		ori = new int[N+1];
		yri = new int[N+1];
		System.out.println(bfs());
	}
	static class Point {
		int now,cnt;
		boolean flag;
		Point(int now, int cnt, boolean flag) {
			this.now = now;
			this.cnt = cnt;
			this.flag = flag;
		}
	}
}