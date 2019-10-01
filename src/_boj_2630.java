import java.io.*;
import java.util.*;
public class _boj_2630 {
	static int map[][];
	static int N;
	static int w_cnt,b_cnt; //0,1

	static boolean isPossible(int sr,int sc,int er,int ec) {
//		System.out.println(sr + " " + sc);
		int color = map[sr][sc];
		for(int i = sr ; i <= er ; i++) {
			for(int j = sc ; j <= ec ; j++) {
				if(map[i][j] != color) return false;
			}
		}
		return true;
	}


	static void go(int sr,int sc,int er,int ec) {
		if(isPossible(sr,sc,er,ec)) {
			if(map[sr][sc] == 0) {
				w_cnt++;
				return;
			}else {
				b_cnt++;
				return;
			}
		}
		int div_r = (sr+er) / 2;
		int div_c = (sc+ec) / 2;
		
		go(sr,sc,div_r,div_c);	// 11시.
		go(sr,div_c+1,div_r,ec); // 1시.
		go(div_r+1,sc,er,div_c); // 7시;
		go(div_r+1,div_c+1,er,ec); // 5시;

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0,0,N-1,N-1);
		System.out.println(w_cnt+"\n"+b_cnt);
	}
}
