import java.io.*;
import java.util.*;

public class _4485_녹색옷입은애가젤다지 {
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int map[][];
	static boolean visited[][];
	static int dist[][];
	static int N;

	static void dijk(int y,int x,int w) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				dist[i][j] = (int)1e9;
			}
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		dist[y][x] = w;
		pq.add(new Point(y,x,w));
		while(!pq.isEmpty()) {
			Point p;
			do{
				p = pq.poll();
			}while(!pq.isEmpty() && visited[p.y][p.x]);
			//if(visited[p.y][p.x]) break;
			visited[p.y][p.x] = true;
			for(int k = 0 ; k < 4 ; k++) {
				int ny = p.y + dy[k];
				int nx = p.x + dx[k];
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
				if(dist[ny][nx] > dist[p.y][p.x] + map[ny][nx]) {
					dist[ny][nx] = dist[p.y][p.x] + map[ny][nx];
					pq.add(new Point(ny,nx,dist[ny][nx]));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int tc = 1;
		while(N !=0) {
			map = new int[N][N];
			visited = new boolean[N][N];
			dist = new int[N][N];

			for(int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dijk(0,0,map[0][0]);
			System.out.println("Problem " + tc++ + ": " + dist[N-1][N-1]);
			N = Integer.parseInt(br.readLine());
		}
	}
	static class Point implements Comparable<Point> {
		int y,x,w;
		Point(int y,int x,int w) {
			this.y = y;
			this.x = x;
			this.w = w;
		}
		@Override
		public int compareTo(Point target) {
			if(this.w > target.w) return 1;
			return -1;
		}
	}
}
