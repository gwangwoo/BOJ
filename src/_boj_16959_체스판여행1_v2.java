import java.io.*;
import java.util.*;

public class _boj_16959_체스판여행1_v2 {
	static int N,sr,sc;
	static int dr[][] = {{-2,-2,-1,1,2,2,1,-1},{-1,-1,1,1},{-1,0,1,0}};
	static int dc[][] = {{-1,1,2,2,1,-1,-2,-2},{-1,1,1,-1},{0,1,0,-1}};
	static int mal[] = {8,4,4};
	static int map[][];
	static boolean visited[][][][];
	
	static void bfs() {
		// 0. knight 1. queen, 2. rook;
		visited = new boolean[N][N][3][N*N+2];
		Queue<Point> q = new LinkedList<>();
		for(int i = 0 ; i < 3;  i++) {
			visited[sr][sc][i][1] = true;
			q.add(new Point(sr,sc,i,2));
		}
		int time = 0;
		while(!q.isEmpty()) {
			int q_size = q.size();
			while(q_size-- > 0) {
				Point p = q.poll();
				int r = p.r; int c = p.c; int type = p.type; int next = p.next;
				if(next == N*N+1) {
					System.out.println(time);
					System.exit(0);
				}
				
				for(int k = 0 ; k < mal[type] ; k++) {
					int nr = r + dr[type][k];
					int nc = c + dc[type][k];
					
					while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
						int target = next + (map[nr][nc] == next ? 1 : 0);
						if(!visited[nr][nc][type][target]) {
							visited[nr][nc][type][target] = true;
							q.add(new Point(nr,nc,type,target));
						}
						if(type == 0) break;
						nr += dr[type][k]; nc += dc[type][k];
					}
				}
				
				for(int m = 0 ; m < 3 ; m++) {
					if(m == type) continue;
					if(!visited[r][c][(m+1)%3][next]) {
						q.add(new Point(r,c,(m+1)%3,next));
						visited[r][c][(m+1)%3][next] = true;
					}
					if(!visited[r][c][(m+2)%3][next]) {
						q.add(new Point(r,c,(m+2)%3,next));
						visited[r][c][(m+2)%3][next] = true;
					}
				}
			}
			time++;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					sr = i; sc = j;
				}
			}
		}
		
		bfs();
	}
	static class Point {
		int r,c,type,next;
		Point(int r,int c,int type,int next) {
			this.r = r;
			this.c = c;
			this.type = type;
			this.next = next;
		}
	}
}
