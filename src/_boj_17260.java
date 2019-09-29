import java.io.*;
import java.util.*;

public class _boj_17260 {
	static int N,K;
	static ArrayList<Integer> arl[];
	static Point arr[];
	static PriorityQueue<Point> q = new PriorityQueue<>();

	static boolean bfs() {
		boolean visited[] = new boolean[N];
		for(int i = 0 ; i < N ; i++) {
			if(i == K) continue;
			q.add(new Point(arr[i].height,arr[i].idx));
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			int height = p.height;
			int idx = p.idx;
			if(idx == K) return true;
			for(int y : arl[idx]) {
				if(!visited[y] && height >= arr[y].height) {
					q.add(new Point(arr[y].height + (height-arr[y].height)/2 , y));
					visited[y] = true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		arr = new Point[N];
		for(int i = 0 ; i  < N ;i++) {
			arr[i] = new Point(Integer.parseInt(st.nextToken()), i);
		}
		arl = new ArrayList[N];
		for(int i = 0 ; i < arl.length ; i++) arl[i] = new ArrayList<>();
		for(int i = 0 ; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			arl[u].add(v);
			arl[v].add(u);
		}

		if(bfs()) {
			System.out.println(1);
			System.exit(0);
		}
		System.out.println(0);

	}
	static class Point implements Comparable<Point>{
		int height;
		int idx;
		Point(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
		@Override
		public int compareTo(Point target) {
			if(this.height > target.height) return -1;
			else if(this.height < target.height) return 1;
			return 0;
		}
	}
}
