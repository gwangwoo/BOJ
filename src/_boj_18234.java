import java.io.*;
import java.util.*;
public class _boj_18234 {
	static int N,T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		long ans = 0L;
		for(int i = 0 ; i < N ; i++) {
			Point p = pq.poll();
			ans += (T-N+i) * (long)p.p + p.w;
		}
		System.out.println(ans);
		
	}
	static class Point implements Comparable<Point>{
		int w,p;
		Point(int w,int p) {
			this.w = w;
			this.p = p;
		}
		@Override
		public int compareTo(Point target) {
			if(this.p < target.p) return -1;
			else if(this.p > target.p) return 1;
			return 0;
		}
	}
}
