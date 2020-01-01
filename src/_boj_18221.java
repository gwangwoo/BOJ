import java.io.*;
import java.util.*;
public class _boj_18221 {
	static int N;
	static int map[][];
	static int sr,sc,er,ec;
	// tr lc || br rc
	
	static double df() {
		return Math.sqrt(Math.pow(sr-er,2)+Math.pow(sc-ec, 2));
	}
	
	static boolean isPossible() {
		int lc = sc>ec?ec:sc;
		int tr = sr>er?er:sr;
		int rc = sc<ec?ec:sc;
		int br = sr<er?er:sr;
		int cnt = 0;
		for(int i = tr ; i <= br ; i++) {
			for(int j = lc ; j <= rc ; j++) {
				if(map[i][j] == 1) cnt++;
			}
		}
		if(cnt >= 3) return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 5) {
					er = i;
					ec = j;
				}else if(map[i][j] == 2) {
					sr = i;
					sc = j;
				}
			}
		}
		
		if(df() >= 5 && isPossible()) {
			System.out.println(1);
		}else System.out.println(0);
	}
}
