import java.util.*;
import java.io.*;
// 
public class _1600_말이되고픈원숭이 {
	static int K,W,H;
	static int map[][];
	static int dist[][][];
	static final int dx[] = {-1,0,1,0};
	static final int dy[] = {0,1,0,-1};
	static final int hx[] = {-2,-1,1,2,2,1,-1,-2};
	static final int hy[] = {1,2,2,1,-1,-2,-2,-1};
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void bfs(int x,int y, int k) throws IOException {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0));
		dist[0][0][0] = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == H-1 && p.y == W-1) {
				bw.write(Integer.toString(dist[p.x][p.y][p.k] -1 ));
				bw.flush();
				System.exit(0);
			}
			
			//System.out.println(p.x + " " + p.y + " " + p.k);
			for(int l = 0 ; l < 4 ; l++) {
				int nx = p.x + dx[l];
				int ny = p.y + dy[l];
				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				if(map[nx][ny] == 0 && dist[nx][ny][p.k] == 0) {
					q.add(new Point(nx,ny,p.k));
					dist[nx][ny][p.k] = dist[p.x][p.y][p.k] + 1;
				}
			}
			if(p.k >= K) continue;
			for(int l = 0 ; l < 8 ; l++) {
				int nx = p.x + hx[l];
				int ny = p.y + hy[l];
				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
//				System.out.println(nx + " " + ny + " " + p.x + " " + p.y);
				if(map[nx][ny] == 0 && dist[nx][ny][p.k+1] == 0) {
					q.add(new Point(nx,ny,p.k+1));
					dist[nx][ny][p.k+1] = dist[p.x][p.y][p.k] + 1;
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		dist = new int[H][W][K+1];
		for(int i = 0 ; i < H ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < W ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0,0,0);
		bw.write("-1");
		bw.flush();
	}
	static class Point {
		int x,y,k;
		Point(int x,int y,int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
}


