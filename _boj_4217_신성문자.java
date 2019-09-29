import java.io.*;
import java.util.*;

public class _boj_4217_신성문자 {
	static int H,W;
	static final int dr[] = {-1,0,1,0};
	static final int dc[] = {0,1,0,-1};
	static int map[][];
	static int check[][];

	static void bfs(int r, int c, int cnt) {
		Queue<Point> q = new LinkedList<>();
		check[r][c] = cnt;
		q.add(new Point(r,c));
		while(!q.isEmpty()) {
			Point p = q.poll();
			r = p.r;
			c = p.c;

			for(int k = 0 ; k <4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= 400 || nc < 0 || nc >= 500 || check[nr][nc] != 0) continue;
				if(map[r][c] == map[nr][nc]) {
					q.add(new Point(nr,nc));
					check[nr][nc] = cnt;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1 ; ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			if(H == 0 && W == 0) return;
			char tmp[][] = new char[H+1][W+1];
			map = new int[800][800];
			check = new int[800][800];
			for(int i = 1 ; i <= H ; i++) {
				String str = br.readLine();
				ArrayList<Character> arl = new ArrayList<>();
				for(int j = 1 ; j <= W ; j++) {
					tmp[i][j] = str.charAt(j-1);
					if('0' <= tmp[i][j] && tmp[i][j] <= '9') {
						int now = tmp[i][j]-'0';
						switch(now) {
						case 0:
							arl.add('0'); arl.add('0'); arl.add('0'); arl.add('0');
							break;
						case 1:
							arl.add('0'); arl.add('0'); arl.add('0'); arl.add('1');
							break;
						case 2:
							arl.add('0'); arl.add('0'); arl.add('1'); arl.add('0');
							break;
						case 3:
							arl.add('0'); arl.add('0'); arl.add('1'); arl.add('1');
							break;
						case 4:
							arl.add('0'); arl.add('1'); arl.add('0'); arl.add('0');
							break;
						case 5:
							arl.add('0'); arl.add('1'); arl.add('0'); arl.add('1');
							break;
						case 6:
							arl.add('0'); arl.add('1'); arl.add('1'); arl.add('0');
							break;
						case 7:
							arl.add('0'); arl.add('1'); arl.add('1'); arl.add('1');
							break;
						case 8:
							arl.add('1'); arl.add('0'); arl.add('0'); arl.add('0');
							break;
						case 9:
							arl.add('1'); arl.add('0'); arl.add('0'); arl.add('1');
							break;
						}
					}else {
						String t = Integer.toBinaryString((tmp[i][j] - 87));
						for(int k = 0 ; k < t.length() ; k++) {
							arl.add(t.charAt(k));
						}
					}
				}
				for(int k = 1 ; k <= arl.size() ; k++) {
					map[i][k] = arl.get(k-1)-'0';
				}
			}
			
			int cnt = 1;
			for(int i = 0 ; i <= H+1 ; i++) {
				for(int j = 0 ; j <= W*4+1 ; j++) {
					if(check[i][j] == 0) {
						bfs(i,j,cnt++);
					}
				}
			}
			
//			for(int i = 0 ; i <= H+1 ; i++) {
//				for(int j = 0 ; j <= W*4+1 ; j++) {
//					System.out.print(check[i][j]);
//				}
//				System.out.println();
//			}
			
			
			HashSet<Integer> arr[] = new HashSet[cnt+1];
			for(int i = 1 ; i <= cnt ; i++) {
				arr[i] = new HashSet<>();
			}

			for(int i = 1 ; i <= 400 ; i++) {
				for(int j = 1 ; j <= 500 ; j++) {
					if(map[i][j] == 1) {
						for(int k = 0 ; k < 4 ; k++) {
							int nr = i + dr[k]; int nc = j + dc[k];
							if(nr < 0 || nr >= 400 || nc < 0 || nc >= 500) continue;
							if(check[nr][nc] != 0) {
								if(check[i][j] == check[nr][nc]) continue;
								arr[check[i][j]].add(check[nr][nc]);
							}
						}
					}
				}
			}
			ArrayList<String> ans = new ArrayList<>();
			for(int i = 1 ; i <= cnt ; i++) {
				if(arr[i].size() >= 1) {
					switch(arr[i].size()-1) {
					case 1:
						ans.add("A");
						break;
					case 3:
						ans.add("J");
						break;
					case 5:
						ans.add("D");
						break;
					case 4:
						ans.add("S");
						break;
					case 0:
						ans.add("W");
						break;
					case 2:
						ans.add("K");
						break;
					}
				}
			}
			Collections.sort(ans);
			System.out.print("Case " + tc + ": ");
			for(int i = 0 ; i < ans.size() ; i++) {
				System.out.print(ans.get(i));
			}
			System.out.println();

		}
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}

}
