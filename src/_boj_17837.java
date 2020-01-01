import java.util.*;
import java.io.*;
public class _boj_17837 {
	static int N,K;
	static int dr[] = {0,0,0,-1,1};
	static int dc[] = {0,1,-1,0,0};
	static int white = 0, red = 1, blue = 2;
	static int map[][];
	static ArrayList<Integer> mal_map[][];
	static ArrayList<Point> arl = new ArrayList<>();

	static boolean isEnd(int r,int c) {
		if(mal_map[r][c].size() >= 4) return true;
		return false;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		mal_map = new ArrayList[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				mal_map[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int idx = 0;
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			mal_map[r][c].add(idx++);
			arl.add(new Point(r,c,dir));
		}

		int time = 0;
		int len = arl.size();
		while(time < 1000) {
			time++;
//			System.out.println("time : " + time);
			for(int i = 0 ; i < len ; i++) {
				Point now = arl.get(i);
				// 자신의 위에 몇개가 있는지를 체크해보자
				int now_h = mal_map[now.r][now.c].indexOf(i);
				int size = mal_map[now.r][now.c].size();
				if(size-now_h == 1) {
					// 내위에 아무도 없고 내자신인 경우.
					int nr = now.r + dr[now.dir];
					int nc = now.c + dc[now.dir];
//					System.out.println(i + " " +  nr + " " + nc + " " + now.r + " " + now.c);
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == blue) {
						if(now.dir == 1 || now.dir == 3) now.dir+=1;
						else if(now.dir == 2 || now.dir == 4) now.dir-=1;
						nr = now.r + dr[now.dir];
						nc = now.c + dc[now.dir];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == blue) continue;
						// 빨강이나 흰색이라면.
						mal_map[nr][nc].add(i); // 현재 내위치 옮기고
						mal_map[now.r][now.c].remove(now_h); // 기존에 있던 내위치 삭제하고
						now.r = nr; now.c = nc; // 새로운 위치로 바꿔준다.
						if(isEnd(nr,nc)) {
							System.out.println(time);
							return;
						}
					}
					// 흰색이라면.
					else if(map[nr][nc] == white) {
							int num = mal_map[now.r][now.c].remove(now_h);
							mal_map[nr][nc].add(num);
							arl.get(num).r = nr;
							arl.get(num).c = nc;
						if(isEnd(nr,nc)) {
							System.out.println(time);
							return;
						}
						// 범위 안나가고 빨간색이라면.
					}else if(map[nr][nc] == red) {
							int num = mal_map[now.r][now.c].remove(now_h);
							mal_map[nr][nc].add(num);
							arl.get(num).r = nr;
							arl.get(num).c = nc;
						if(isEnd(nr,nc)) {
							System.out.println(time);
							return;
						}
					}
				}else if(size-now_h >= 2) {
					// 내위에 사람있음
					int nr = now.r + dr[now.dir];
					int nc = now.c + dc[now.dir];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == blue) {
						if(now.dir == 1 || now.dir == 3) now.dir+=1;
						else if(now.dir == 2 || now.dir == 4) now.dir-=1;
						nr = now.r + dr[now.dir];
						nc = now.c + dc[now.dir];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == blue) continue;
						// 아니라면 다같이 옮겨줘야됨
						// 흰색일 경우.
						if(map[nr][nc] == white) {
							int r = now.r;
							int c = now.c;
							for(int j = now_h ; j < size ; j++) {
								int num = mal_map[r][c].remove(now_h);
								mal_map[nr][nc].add(num);
								arl.get(num).r = nr;
								arl.get(num).c = nc;
							}
							if(isEnd(nr,nc)) {
								System.out.println(time);
								return;
							}
						}else if(map[nr][nc] == red) {
							int r = now.r; int c = now.c;
							Stack<Integer> stk = new Stack<>();
							for(int j = now_h ; j < size ; j++) {
								int num = mal_map[r][c].remove(now_h);
								stk.add(num);
								arl.get(num).r = nr;
								arl.get(num).c = nc;
							}
							int ll = stk.size();
							while(ll-- > 0) {
								mal_map[nr][nc].add(stk.pop());
							}
							if(isEnd(nr,nc)) {
								System.out.println(time);
								return;
							}
						}
						// 범위안나가고 흰색이라면.
					}else if(map[nr][nc] == white) {
						int r = now.r;
						int c = now.c;
						for(int j = now_h ; j < size ; j++) {
							int num = mal_map[r][c].remove(now_h);
							mal_map[nr][nc].add(num);
							arl.get(num).r = nr;
							arl.get(num).c = nc;
						}
						if(isEnd(nr,nc)) {
							System.out.println(time);
							return;
						}
						// 범위 안나가고 빨간색이라면.
					}else if(map[nr][nc] == red) {
						int r = now.r;
						int c = now.c;
						Stack<Integer> stk = new Stack<>();
						for(int j = now_h ; j < size ; j++) {
							int num = mal_map[r][c].remove(now_h);
							stk.add(num);
							arl.get(num).r = nr;
							arl.get(num).c = nc;
						}
						int ll = stk.size();
						while(ll-- > 0) {
							mal_map[nr][nc].add(stk.pop());
						}
						if(isEnd(nr,nc)) {
							System.out.println(time);
							return;
						}
					}
				}
//				System.out.println();
//				for(int k = 0 ; k < N ; k++) {
//					for(int j = 0 ; j < N ; j++) {
//						System.out.print(mal_map[k][j].size() + " ");
//					}
//					System.out.println();
//				}
			}
		}
		System.out.println(-1);
	}
	static class Point {
		int r,c,dir;
		Point(int r,int c,int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}
