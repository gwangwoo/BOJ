import java.io.*;
import java.util.*;

public class _13565_침투 {
	static int map[][];
	static int visited[][];
	static int N,M;
	static Queue<Point> q = new LinkedList<>();
	static final int dx[] = {-1,0,1,0};
	static final int dy[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0; j < M ; j++) {
				map[i][j] = str.charAt(j)-'0';
				if(i == 0 && map[i][j] == 0) {
					q.add(new Point(i,j));
					visited[i][j] = 1;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0 ; k <4 ; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(map[nx][ny] == 0 && visited[nx][ny] == 0) {
					q.add(new Point(nx,ny));
					visited[nx][ny] = 1;
				}
			}
		}
		for(int i = 0 ; i < M ; i++) {
			if(visited[N-1][i] == 1) {
				bw.write("YES");
				bw.flush();
				return;
			}
		}
		bw.write("NO");
		bw.flush();
		

	}
	static class Point {
		int x,y;
		Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
