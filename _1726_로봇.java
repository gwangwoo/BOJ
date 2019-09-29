import java.io.*;
import java.util.*;

public class _1726_로봇 {
	static final int dy[] = {0,0,0,1,-1};
	static final int dx[] = {0,1,-1,0,0};
	static int map[][];
	static boolean visited[][][];
	static int N,M;
	static Point start;
	static Point end;

	static int opp(int dir) {
		if(dir == 1) return 2;
		else if(dir == 2) return 1;
		else if(dir == 3) return 4;
		else return 3;
	}
	
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1][5];

		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		start = new Point(0,0,0,0);
		end = new Point(0,0,0,0);
		st = new StringTokenizer(br.readLine());
		start.y = Integer.parseInt(st.nextToken());
		start.x = Integer.parseInt(st.nextToken());
		start.dir = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		end.y = Integer.parseInt(st.nextToken());
		end.x = Integer.parseInt(st.nextToken());
		end.dir = Integer.parseInt(st.nextToken());
		
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x][start.dir] = true;

		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.y == end.y && p.x == end.x && p.dir == end.dir) {
				System.out.println(p.cnt);
				return;
			}

			int ny,nx;
			for(int i = 1; i <= 3 ; i++) {
				ny = p.y + dy[p.dir] * i;
				nx = p.x + dx[p.dir] * i;
				if(ny < 1 || ny > N || nx < 1 || nx > M) break;
				if(map[ny][nx] != 0) break;
				if(!visited[ny][nx][p.dir]) {
					visited[ny][nx][p.dir] = true;
					q.add(new Point(ny,nx,p.dir,p.cnt+1));
				}
			}

			for(int i = 1 ; i<= 4 ; i++) {
				if(i == p.dir || i == opp(p.dir)) continue;
				if(!visited[p.y][p.x][i]) {
					visited[p.y][p.x][i] = true;
					q.add(new Point(p.y,p.x,i,p.cnt+1));
				}
			}

		}
	}
	static class Point {
		int y,x,dir,cnt;
		Point(int y,int x,int dir,int cnt) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
}
