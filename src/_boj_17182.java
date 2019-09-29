import java.io.*;
import java.util.*;

public class _boj_17182 {
	static int val[][];
	static int N,M;
	static int res;
	static int fld[][];
	static boolean isRight(boolean check[]) {
		for(int i = 0 ; i < N ; i++) {
			if(!check[i]) return false;
		}
		return true;
	}
	
	static void dfs(int index, boolean check[], int sum) {
		if(isRight(check)) {
			res = Math.min(res, sum);
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(i == index || check[i]) continue;
			boolean before = check[i];
			check[i] = true;
			dfs(i , check, sum + fld[index][i]);
			check[i] = before;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		val = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				val[i][j] = Integer.parseInt(st.nextToken());
				res += val[i][j];
			}
		}
		// floyd
		fld = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N; j++) {
				fld[i][j] = val[i][j];
			}
		}
		for(int k = 0 ; k < N ; k++) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					fld[i][j] = Math.min(fld[i][j], fld[i][k]+ fld[k][j]);
				}
			}
		}
		boolean check[] = new boolean[N];
		check[M] = true;
		dfs(M, check, 0);
		System.out.println(res);
	}

}
