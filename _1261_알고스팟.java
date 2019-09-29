import java.io.*;
import java.util.*;

public class _1261_알고스팟 {
	static final int dy[] = {-1,0,1,0};
	static final int dx[] = {0,1,0,-1};
	static int M,N;
	static int map[][];
	static boolean visited[][];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dijk(int y,int x) throws IOException{
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0,0,0));
		while(!pq.isEmpty()) {
			Point p;
			do {
				p = pq.poll();
				if(p.y == N-1 && p.x == M-1) {
					bw.write(Integer.toString(p.w));
					bw.flush();
					return;
				}
			}while(!pq.isEmpty() && visited[p.y][p.x]);
			if(visited[p.y][p.x]) break;
			visited[p.y][p.x] = true;
			for(int k = 0 ; k < 4 ; k++) {
				int ny = p.y + dy[k];
				int nx = p.x + dx[k];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
				int nw = p.w + (map[ny][nx] == 1 ? 1 : 0);
				pq.add(new Point(ny,nx,nw));
			}

		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		dijk(0,0);
	}

	static class Point implements Comparable<Point>{
		int x,y,w;
		Point(int y,int x,int w) {
			this.y = y;
			this.x = x;
			this.w = w;
		}
		@Override
		public int compareTo(Point target) {
			if(this.w > target.w) return 1;
			else return -1;
		}
	}
}
