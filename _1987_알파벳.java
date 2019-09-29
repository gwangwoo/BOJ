import java.util.*;

public class _1987_알파벳 {
	static final int dr[] = {-1,0,1,0};
	static final int dc[] = {0,1,0,-1};
	static int R,C;
	static boolean visited[] = new boolean[26];
	static char map[][];
	static int res,MAX;

	static void bt(int r,int c) {
		for(int k = 0 ; k < 4 ; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if(!visited[map[nr][nc] - 'A']) { 
				visited[map[nr][nc] - 'A'] = true;
				res++;
				bt(nr,nc);

				MAX = Math.max(res, MAX);
				res--;
				visited[map[nr][nc] - 'A'] = false;
			}	
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			String str = sc.next();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		MAX = 0;
		res = 1;
		visited[map[0][0] - 'A'] = true;
		bt(0,0);
		if(MAX == 0) MAX = 1;
		System.out.println(MAX);
	}

}