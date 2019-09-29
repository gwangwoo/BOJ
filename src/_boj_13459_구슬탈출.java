import java.io.*;
import java.util.*;

public class _boj_13459_구슬탈출 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static String res_str = "";
	static int N,M;
	static int Or,Oc;
	static int res;
	static char map[][];
	
	static void playGame(int Rr,int Rc, int Br, int Bc,int dir , int cnt,String str) {
		if(cnt > 10) return;
		int r_cnt = 0;
		int b_cnt = 0;
		boolean r_flag = false;
		boolean b_flag = false;
		
		// 빨강 공 move
		while(true) {
			int nr = Rr + dr[dir];
			int nc = Rc + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#') break;
			r_cnt++;
			if(nr == Or && nc == Oc) {
				r_flag = true;
				break;
			}
			Rr = nr;
			Rc = nc;
		}
		// 파랑 공 move
		while(true) {
			int nr = Br + dr[dir];
			int nc = Bc + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#') break;
			b_cnt++;
			if(nr == Or && nc == Oc) {
				b_flag = true;
				break;
			}
			Br = nr;
			Bc = nc;
		}
		if(r_flag && b_flag) {
			return;
		}else if(b_flag) {
			return;
		}else if(r_flag) {
			if(cnt < res) {
				res = cnt;
				res_str = str;
				return;
			}
		}
		
		if(Rr == Br && Rc == Bc) {
			if(r_cnt > b_cnt) {
				Rr = Br - dr[dir];
				Rc = Bc - dc[dir];
			}else {
				Br = Rr - dr[dir];
				Bc = Rc - dc[dir];
			}
		}
		for(int k = 0 ; k < 4 ; k++) {
			if(k == dir) continue;
			playGame(Rr,Rc,Br,Bc,k,cnt+1, str+k);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int Rr = 0,Rc = 0,Br = 0,Bc = 0;
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'B') {
					Br = i; Bc = j;
				}else if(map[i][j] == 'R') {
					Rr = i; Rc = j;
				}else if(map[i][j] == 'O') {
					Or = i; Oc = j;
				}
			}
		}
		res = (int)1e9;
		for(int k = 0 ; k < 4 ; k++) {
			playGame(Rr,Rc,Br,Bc,k,1,""+k);
		}
		if(res == (int)1e9) {
			System.out.println("XHAE");
		}else {
			System.out.println(res);
			for(int i = 0 ; i < res_str.length() ; i++) {
				switch(res_str.charAt(i)) {
				case '0':
					System.out.print("U");
					break;
				case '1':
					System.out.print("R");
					break;
				case '2':
					System.out.print("D");
					break;
				case '3':
					System.out.print("L");
					break;
				}
			}
			System.out.println();
		}
		
	}

}
