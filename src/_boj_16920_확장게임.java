import java.io.*;
import java.util.*;

public class _boj_16920_확장게임 {
	static int S[];
	static char map[][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static int N,M,P;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		int ans[] = new int[P+1];
		S = new int[P+1];
		map = new char[N][M];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= P ; i++) S[i] = Integer.parseInt(st.nextToken());
		Queue<Pair> q[] = new LinkedList[P+1];
		for(int i = 1; i <= P ; i++) q[i] = new LinkedList<>();
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
				if('1' <= map[i][j] && map[i][j] <= '9') {
					q[map[i][j]-'0'].add(new Pair(i,j));
					ans[map[i][j]-'0']++;
				}
			}
		}
		while(true) {
			for(int i = 1 ; i <= P ; i++) {
				int e = 0;
				while(q[i].size() > 0) {
					int sz = q[i].size();
					while(sz-- >0) {
						Pair p = q[i].poll();
						int r = p.r; int c = p.c;
						for(int k = 0 ; k < 4 ; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != '.') continue;
							map[nr][nc] = map[r][c];
							q[i].add(new Pair(nr,nc));
							ans[map[nr][nc]-'0']++;
						}
					}
					// 확장속도만큼 전진시켜준다.
					++e;
					if(e == S[i]) break;
				}
			}
			// q들에 더이상 값들이 없다면 종료.
			boolean flag = true;
			for(int i = 1 ; i <= P ; i++) {
				if(q[i].size() > 0) flag = false;
			}
			if(flag) break;
		}
		for(int i = 1 ; i <= P ; i++) System.out.print(ans[i] + " ");
	}

	static class Pair {
		int r,c;
		Pair(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}