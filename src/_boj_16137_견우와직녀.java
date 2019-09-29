import java.io.*;
import java.util.*;

public class _boj_16137_견우와직녀 {
	static ArrayList<Point> cand;
	static int N,M;
	static int res = (int)1e9;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int map[][];
	
	static void bfs(int r,int c) {
		int result = 0;
		Queue<Bridge> q = new LinkedList<>();
		int visited[][] = new int[N][N];
		q.add(new Bridge(r,c,0,false));
		visited[r][c] = 1;
		while(!q.isEmpty()) {
			Bridge p = q.poll();
			r = p.r;
			c = p.c;
			int time = p.time;
			boolean isUse = p.isUse;
//			System.out.println(r+ " " + c + " " + time + " " + isUse);
			if(r == N-1 && c == N-1) {
				res = Math.min(time, res);
				break;
			}
			
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] == 1) continue;
				
				if(map[nr][nc] >= 2 && !isUse) {
					if(((time+1) % map[nr][nc]) == 0) {
						visited[nr][nc] = 1;
						q.add(new Bridge(nr,nc,time+1,true));
						continue;
					}else {
						q.add(new Bridge(r,c,time+1,false));
						continue;
					}
				}else if(map[nr][nc] == 1) {
					visited[nr][nc] = 1;
					q.add(new Bridge(nr,nc,time+1,false));
				}
			}
		}
	}
	
	static boolean isPossible(Point now) {
		int r = now.r;
		int c = now.c;
		int val = 0;
		ArrayList<Integer> arr2 = new ArrayList<>();
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(map[nr][nc] == 1) {
				val++;
				arr2.add(k);
			}
		}
		if(val != 2) return false;
		int sum = arr2.get(0) + arr2.get(1);
		if(sum % 2 == 1) return false;
		else return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cand = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					cand.add(new Point(i,j));
				}
			}
		}
		// 오작교를 놓을 수 있는 경우.
		for(int i = 0 ; i < cand.size() ; i++) {
			if(!isPossible(cand.get(i))) {
				cand.remove(i);
			}
		}
		// 다리를 안놓는 경우.
		bfs(0,0);
		for(int i = 0 ; i < cand.size(); i++) {
			map[cand.get(i).r][cand.get(i).c] = M;
			bfs(0,0);
			map[cand.get(i).r][cand.get(i).c] = 0;
		}
		System.out.println(res);
		
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Bridge {
		int r,c,time;
		boolean isUse;
		Bridge(int r,int c,int time, boolean isUse) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.isUse = isUse;
			
		}
	}
}
