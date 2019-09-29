import java.io.*;
import java.util.*;

public class _boj_15898_피아의아틀리에신비한대회의연금술사 {
	static int map[][][];
	static char map_color[][][];
	static ArrayList<Integer> cand = new ArrayList<>();
	static ArrayList<Integer> cand_time = new ArrayList<>();
	static Gama res[][];
	static Gama prev[][][][];
	static int result;
	static int N;

	static int goGame(int type , int dir, int time) {
		int result = 0;
		int index1 = 0; int index2 = 0;
		String t = Integer.toString(type);
		StringBuilder sb = new StringBuilder(t);
		ArrayList<Integer> arl = new ArrayList<>(3);
		if(sb.length() == 4) {
			for(int i = 0; i < 3 ; i++) {
				if(sb.charAt(i) == '1' && sb.charAt(i+1) == '0') {
					index1 = i;
					index2 = i+1;
					break;
				}
			}
			for(int i = 0 ; i < 4 ; i++) {
				if(i == index1) arl.add(10);
				else if(i == index2) continue;
				else arl.add(sb.charAt(i)-'0');
			}
		}else {
			for(int i = 0 ; i < 3 ; i++) {
				arl.add(sb.charAt(i)-'0');
			}
		}
		int divide = 100;
		for(int i = 0 ; i < 3 ; i++) {
			int now = arl.get(i);
			int rotate = dir / divide;
			int locate = time / divide;

			Gama tmp[][] = new Gama[4][4];
			for(int r = 0 ; r < 4 ; r++) {
				for(int c = 0; c < 4 ; c++) {
					tmp[r][c] = prev[now-1][rotate-1][r][c];
				}
			}
			// here
			int sr = 0,sc = 0;
			switch(locate) {
			case 1:
				sr = 0; sc = 0;
				break;
			case 2:
				sr = 0; sc = 1;
				break;
			case 3:
				sr = 1; sc = 0;
				break;
			case 4:
				sr = 1; sc = 1;
				break;
			}
			for(int j = sr ; j < 4+sr ; j++) {
				for(int k = sc ; k < 4+sc ; k++) {
					Gama target = tmp[j-sr][k-sc];
					// color.
					if(target.color != 'W') {
						res[j][k].color = target.color;
					}
					// performence
					res[j][k].val = target.val + res[j][k].val;
					if(res[j][k].val < 0) res[j][k].val = 0;
					else if(res[j][k].val > 9) res[j][k].val = 9;
				}
			}
			if(i == 2) break;
			dir %= divide;
			time %= divide;
			divide /= 10;
		}
		int R_cnt = 0; int B_cnt = 0; int G_cnt = 0; int Y_cnt = 0;
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(res[i][j].color == 'W') {
					res[i][j].val = 0;
					continue;
				}
				if(res[i][j].color == 'R') {
					R_cnt += res[i][j].val;
					res[i][j].color = 'W';
					res[i][j].val = 0;
				}
				else if(res[i][j].color == 'B') {
					B_cnt += res[i][j].val;
					res[i][j].color = 'W';
					res[i][j].val = 0;
				}
				else if(res[i][j].color == 'G') {
					G_cnt += res[i][j].val;
					res[i][j].color = 'W';
					res[i][j].val = 0;
				}
				else if(res[i][j].color == 'Y') {
					Y_cnt += res[i][j].val;
					res[i][j].color = 'W';
					res[i][j].val = 0;
				}
			}
		}
		
		result = 7*R_cnt + 5*B_cnt + 3*G_cnt + 2*Y_cnt;
		return result;
	}

	static void dfs_time(int cnt, int str, int type, int dir) {
		if(cnt == 3) {
			int val = goGame(type,dir,str);
			result = Math.max(val, result);
			return;
		}
		for(int i = 1 ; i <= 4 ; i++) dfs_time(cnt+1,str*10+i,type,dir);

	}

	
	static void dfs_dir(int cnt, int str, int type) {
		if(cnt == 3) {
			dfs_time(0,0,type,str);
			return;
		}
		for(int i = 1 ; i <= 4 ; i++) dfs_dir(cnt+1,str*10+i,type);

	}

	static void dfs(boolean visited[], int cnt, int str) {
		if(cnt == 3) {
			dfs_dir(0,0,str);
			return;
		}
		for(int i = 1 ; i <= N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(i == 10) dfs(visited , cnt+1 , str*100+i);
				else dfs(visited, cnt+1, str*10+i);
				visited[i] = false;
			}
		}
	}

	static void init() {
		res = new Gama[5][5];
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				res[i][j] = new Gama(0,'W');
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int cnt = 0 ; cnt < 4 ; cnt++) {
				if(cnt == 0) {
					for(int k =0  ; k < 4 ; k++) {
						for(int l = 0 ; l < 4 ; l++) {
							prev[i][cnt][k][l] = new Gama(map[i][k][l],map_color[i][k][l]);
						}
					}
				}
				else if(cnt == 1) {
					for(int j = 0 ; j < 4 ; j++) prev[i][cnt][0][j] = new Gama(map[i][j][3],map_color[i][j][3]);
					for(int j = 0 ; j < 4 ; j++) prev[i][cnt][1][j] = new Gama(map[i][j][2],map_color[i][j][2]);
					for(int j = 0 ; j < 4 ; j++) prev[i][cnt][2][j] = new Gama(map[i][j][1],map_color[i][j][1]);
					for(int j = 0 ; j < 4 ; j++) prev[i][cnt][3][j] = new Gama(map[i][j][0],map_color[i][j][0]);
				}
				else if(cnt == 2) {
					for(int j = 3 ; j >= 0 ; j--) prev[i][cnt][3][j] = new Gama(map[i][0][3-j],map_color[i][0][3-j]);
					for(int j = 3 ; j >= 0 ; j--) prev[i][cnt][2][j] = new Gama(map[i][1][3-j],map_color[i][1][3-j]);
					for(int j = 3 ; j >= 0 ; j--) prev[i][cnt][1][j] = new Gama(map[i][2][3-j],map_color[i][2][3-j]);
					for(int j = 3 ; j >= 0 ; j--) prev[i][cnt][0][j] = new Gama(map[i][3][3-j],map_color[i][3][3-j]);
				}
				else if(cnt == 3) {
					for(int j = 0 ; j < 4 ; j++) prev[i][cnt][j][3] = new Gama(map[i][0][j], map_color[i][0][j]);
					for(int j = 0 ; j < 4 ; j++) prev[i][cnt][j][2] = new Gama(map[i][1][j], map_color[i][1][j]);
					for(int j = 0 ; j < 4 ; j++) prev[i][cnt][j][1] = new Gama(map[i][2][j], map_color[i][2][j]);
					for(int j = 0 ; j < 4 ; j++) prev[i][cnt][j][0] = new Gama(map[i][3][j], map_color[i][3][j]);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		map = new int[N][4][4];
		map_color = new char[N][4][4];
		prev = new Gama[N][4][4][4];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < 4 ; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
			for(int j = 0 ; j < 4 ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < 4 ; k++) {
					map_color[i][j][k] = st.nextToken().charAt(0);
				}
			}
		}
		init();
		boolean visited[] = new boolean[N+1];
		dfs(visited, 0, 0);
		System.out.println(result);


	}
	static class Gama {
		int val;
		char color;
		Gama(int val, char color) {
			this.val = val;
			this.color = color;
		}
	}
}

