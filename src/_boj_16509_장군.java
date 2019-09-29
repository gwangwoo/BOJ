import java.io.*;
import java.util.*;

public class _boj_16509_장군 {
	static int map[][] = new int[10][9];
	static int dr[] = {-3,-3,-2,2,3,3,2,-2};
	static int dc[] = {-2,2,3,3,2,-2,-3,-3};
	static int visited[][];
	static int q[][] = new int[1000][2];
	static int front,rear;
	static void bfs(int sr,int sc) {
		front = rear = 0;
		q[rear][0] = sr;
		q[rear++][1] = sc;
		while(front < rear) {
			int r = q[front][0];
			int c = q[front++][1];
			
			for(int k = 0 ; k < 8 ; k++) {
				if(!isOk(r,c,k)) continue;
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(visited[nr][nc] == 0 && map[nr][nc] == 0) {
					q[rear][0] = nr;
					q[rear++][1] = nc;
					visited[nr][nc] = visited[r][c] + 1;
				}else if(map[nr][nc] == 1) {
					System.out.println(visited[r][c]);
					System.exit(0);
				}
			}
		}
		System.out.println(-1);
		return;
	}
	
	static boolean isOk(int r,int c,int mod) {
		int nr = r + dr[mod];
		int nc = c + dc[mod];
		if(nr < 0 || nr >= 10 || nc < 0 || nc >= 9) return false;
		switch(mod) {
		case 0:
			if(map[r-1][c] == 1 || map[r-2][c-1] == 1) return false;
			break;
		case 1:
			if(map[r-1][c] == 1 || map[r-2][c+1] == 1) return false;
			break;
		case 2:
			if(map[r][c+1] == 1 || map[r-1][c+2] == 1) return false;
			break;
		case 3:
			if(map[r][c+1] == 1 || map[r+1][c+2] == 1) return false;
			break;
		case 4:
			if(map[r+1][c] == 1 || map[r+2][c+1] == 1) return false;
			break;
		case 5:
			if(map[r+1][c] == 1 || map[r+2][c-1] == 1) return false;
			break;
		case 6:
			if(map[r][c-1] == 1 || map[r+1][c-2] == 1) return false;
			break;
		case 7:
			if(map[r][c-1] == 1 || map[r-1][c-2] == 1) return false;
			break;
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visited = new int[10][9];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		visited[sr][sc] = 1;
		st = new StringTokenizer(br.readLine());
		int er = Integer.parseInt(st.nextToken());
		int ec = Integer.parseInt(st.nextToken());
		map[er][ec] = 1;
		
		bfs(sr,sc);
	}
}
