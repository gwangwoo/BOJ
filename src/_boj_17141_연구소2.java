import java.io.*;
import java.util.*;

public class _boj_17141_연구소2 {
	static ArrayList<Point> virus = new ArrayList<>();
	static HashSet<String> hs = new HashSet<>();
	static int N,M;
	static int rear,front;
	static int map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int res;
	static int all;
	static void init(int visited[][]) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				visited[i][j] = 0;
			}
		}
	}

	static void copy(int now[][], int target[][]) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				target[i][j] = now[i][j];
			}
		}
	}

	static void dfs(int index, int cnt, String str) {
		if(index > virus.size() || cnt > M) return;
		dfs(index+1 , cnt+1, str+index);
		dfs(index+1, cnt, str);
		hs.add(str);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		res = (int)1e9;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new Point(i,j));
				}else if(map[i][j] == 0) all++;
			}
		}

		dfs(0,0,"");
		int tmp[][] =  new int[N][N];
		int q[][] = new int[5000][2];
		int visited[][] = new int[N][N];
		for(String y : hs) {
//			if(y.equals("")) continue;
			copy(map,tmp);
			init(visited);
			front = rear = 0;
			for(int j = 0 ; j < y.length() ; j++) {
				int target = y.charAt(j)-'0';
				tmp[virus.get(target).r][virus.get(target).c] = 2;
				q[rear][0] = virus.get(target).r;
				q[rear++][1] = virus.get(target).c;
			}
			int time = 0;
			int cnt = 0;
			boolean exit = false;
			while(front < rear) {
				int q_size = rear-front;
				time++;
				while(q_size-- > 0) {
					int r = q[front][0];
					int c = q[front++][1];

					for(int k = 0 ; k < 4 ; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] != 0 || tmp[nr][nc] == 1) continue;
						q[rear][0] = nr;
						q[rear++][1] = nc;
						visited[nr][nc] = visited[r][c] + 1;
						if(tmp[nr][nc] == 0) cnt++;
						if(all == cnt) {
							exit = true;
//							System.out.println(all+ " " + y);
							break;
						}
					}
					if(exit) break;
				}
				if(exit) break;
			}
//			time-=1;
			boolean flag = false;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0;  j < N ; j++) {
					if(visited[i][j] == 0 && tmp[i][j] == 0) {
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			if(flag) continue;
			else res = Math.min(time, res);
		}	
		if(res == (int)1e9) System.out.println(-1);
		else System.out.println(res);
	}
	static class Point {
		int r,c;
		Point(int r,int c){
			this.r = r;
			this.c = c;
		}
	}
}