import java.util.*;
import java.io.*;

public class _swea_3378 {
	static int R, C, S;
	static int a, b, c, d, e, f, dcnt;
	static int N, M;
	static final int H = 11;
	static final int W = 81;

	static char map[][] = new char[11][81];
	static char map2[][] = new char[11][81];


	static boolean isOK(int X,int Y,int Z) {
		int ta = 0,tb = 0,tc = 0,td = 0,te = 0,tf = 0;
		a = b = c = d = e = f = 0;
		for(int i = 0 ; i < N ; i++) {
			boolean bflag = false;
			boolean dflag = false;
			dcnt = 0;
			for(int j = 0 ; j < map[i].length ; j++) {
				if(j == 0 && !isAlpha(map[i][j])) {
					// 처음이고 괄호인 애들.
					bflag = true;
					doBraket(map[i][j]);
				}else if(bflag && map[i][j] != '.' && !isAlpha(map[i][j])) {
					// 첫번째도 괄호였고 계속해서 괄호인 경우.
					doBraket(map[i][j]);
				}else if(isBraket(map[i][j])) {
					// 평상시에 괄호인애들 
					doBraket(map[i][j]);
					dflag = false;
					bflag = false;
				}else if(j == 0 && map[i][j] == '.') {
					dflag = true;
					dcnt++;
				}else if(dflag && map[i][j] == '.') {
					dcnt++;
				}else {
					dflag = false;
					bflag = false;
				}
			}
			int val = (X*(ta-tb) + Y*(tc-td) + Z*(te-tf));
			if(val != dcnt) return false;
			ta = a;	tb = b;	tc = c; td = d;	te = e;	tf = f;
		}
		return true;

	}


	static void init() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = ' ';
				map2[i][j] = ' ';
			}
		}
		R = C = S = 0;
		a = b = c = d = e = f = dcnt = 0;
	}

	static boolean isBraket(char now) {
		if(now == '(' || now == ')' || now == '{' || now == '}' || now == '[' || now == ']') return true;
		return false;
	} 

	static boolean isAlpha(char now) {
		if (('A' <= now && now <= 'Z') || ('a' <= now && now <= 'z'))
			return false;
		return true;
	}

	static void doBraket(char now) {
		switch(now) {
		case '(':
			a++;
			break;
		case ')':
			b++;
			break;
		case '{':
			c++;
			break;
		case '}':
			d++;
			break;
		case '[':
			e++;
			break;
		case ']':
			f++;
			break;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			init();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// 입력완료.
			for(int i = 0 ; i < N ; i++) {
				String str = br.readLine();
				for(int j = 0 ; j < str.length() ; j++) {
					map[i][j] = str.charAt(j);
				}
			}


			for(int i = 0 ; i < M ; i++) {
				String str = br.readLine();
				for(int j = 0;  j < str.length() ; j++) {
					map2[i][j] = str.charAt(j);
				}
			}

			ArrayList<Point> res = new ArrayList<>();

			for(int x = 1; x <= 20 ; x++) {
				for(int y = 1 ; y <= 20 ; y++) {
					for(int z = 1; z <= 20 ;z++) {
						if(isOK(x,y,z)) {
							res.add(new Point(x,y,z));
						}
					}
				}
			}

			a = b = c = d = e = f = 0;

			int arr[][] = new int[res.size()][M];
			
			for(int k = 0 ; k < res.size() ; k++) {
				a = 0; b = 0; c = 0; d = 0; e = 0; f = 0;
				R = res.get(k).x; C = res.get(k).y; S = res.get(k).z;
				for(int i = 0 ; i < M-1 ; i++) {
					for(int j = 0 ; j < map2[i].length ; j++) {
						char now = map2[i][j];
						if(isBraket(now)) {
							doBraket(now);
						}
					}
					arr[k][i] = R*(a-b) + C*(c-d) + S*(e-f);
				}
			}
			StringBuilder sb = new StringBuilder("#"+tc + " 0 ");
			for(int i = 0 ; i < M-1 ; i++) {
				boolean flag = false;
				for(int j = 0 ; j < res.size()-1 ; j++) {
					if(arr[j][i] != arr[j+1][i]) {
						sb.append(-1 + " ");
						flag = true;
						break;
					}
				}
				if(flag) continue;
				else sb.append(arr[0][i] + " ");
			}
			
			System.out.println(sb.toString());
		
		}
	}
	static class Point {
		int x,y,z;
		Point(int x,int y,int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
