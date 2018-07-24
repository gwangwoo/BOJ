import java.io.*;
import java.util.*;

public class _6593_상범빌딩 {
	static int dy[] = {-1,0,1,0,0,0};
	static int dx[] = {0,1,0,-1,0,0};
	static int dz[] = {0,0,0,0,1,-1};
	static char map[][][];
	static int dist[][][];
	static int N,M,K;
	static int startx,starty,startz;
	static int endx,endy,endz;
	
	static void dijk() {
		for(int i = 0 ; i < K ; i++) {
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < M ; k++) {
					dist[i][j][k] = (int)1e9;
				}
			}
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		dist[startz][starty][startx] = 0;
		pq.add(new Point(dist[startz][starty][startx],starty,startx,startz));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(p.x == endx && p.y == endy && p.z == endz) break;
			for(int k = 0 ; k < 6 ; k++) {
				int ny = p.y + dy[k];
				int nx = p.x + dx[k];
				int nz = p.z + dz[k];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || nz < 0 || nz >= K) continue;
				if(map[nz][ny][nx] != '#' && dist[nz][ny][nx] > dist[p.z][p.y][p.x] + 1) {
					dist[nz][ny][nx] = dist[p.z][p.y][p.x] + 1;
					pq.add(new Point(dist[nz][ny][nx],ny,nx,nz));
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(K == 0 && N == 0 && M == 0) return;
			map = new char[K][N][M];
			dist = new int[K][N][M];
			
			for(int i = 0 ; i < K ; i++) {
				for(int j = 0 ; j < N ; j++) {
					String str = br.readLine();
					for(int k = 0 ; k < M ; k++) {
						map[i][j][k] = str.charAt(k);
						if(map[i][j][k] == 'S') {
							startx = k; starty = j; startz = i;
						}
						if(map[i][j][k] == 'E') {
							endx = k; endy = j; endz = i;
						}
					}
				}
				br.readLine();
			}
			
			
			
			dijk();
//			for(int i = 0 ; i < K ; i++) {
//				for(int j = 0 ; j < N ; j++) {
//					for(int k = 0 ; k < M ; k++) {
//						System.out.print(dist[i][j][k]);
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
			if(dist[endz][endy][endx] == (int)1e9) {
				System.out.println("Trapped!");
			}else {
				System.out.println("Escaped in " + dist[endz][endy][endx] + " minute(s).");
			}
		}
			
	}
	static class Point implements Comparable<Point> {
		int y,x,z,weight;
		Point(int weight,int y,int x,int z) {
			this.weight = weight;
			this.y = y;
			this.x = x;
			this.z = z;
		}
		@Override
		public int compareTo(Point target) {
			if(this.weight > target.weight) return 1;
			else return -1;
		}
	}

}
