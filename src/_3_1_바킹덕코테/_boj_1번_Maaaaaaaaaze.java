package _3_1_바킹덕코테;
import java.util.*;
import java.io.*;

public class _boj_1번_Maaaaaaaaaze {
	static int map[][][]=  new int[5][5][5];
	static ArrayList<String> arl = new ArrayList<>();
	static int N = 5;
	static int dr[] = {-1,0,1,0,0,0};
	static int dc[] = {0,1,0,-1,0,0};
	static int dz[] = {0,0,0,0,1,-1};
	static int res = (int)1e9;
	static HashSet<String> hs = new HashSet<>();
	static boolean flag = false;

	static void dfs(boolean check[],int index, String str) {
		if(index == N) {
			StringBuilder sb = new StringBuilder(str);
			if(!hs.contains(sb.toString()) && !hs.contains(sb.reverse().toString()))
			hs.add(str);
		}
		for(int i = 0; i < N ; i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(check, index+1, str+i);
				check[i] = false;
			}
		}
	}


	static void makeIt(int type, int tmp[][]) {
		int arr[][] = new int[N][N];
		for(int i = 0 ; i < type ; i++) {
			for(int k = 0 ; k < N ; k++) arr[k][4] = tmp[0][k];
			for(int k = 0 ; k < N ; k++) arr[k][3] = tmp[1][k];
			for(int k = 0 ; k < N ; k++) arr[k][2] = tmp[2][k];
			for(int k = 0 ; k < N ; k++) arr[k][1] = tmp[3][k];
			for(int k = 0 ; k < N ; k++) arr[k][0] = tmp[4][k];

			// copy;

			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < N ; k++) {
					tmp[j][k] = arr[j][k];
				}
			}
			for(int j = 0 ; j < N ; j++) {
				Arrays.fill(arr[j], 0);
			}
		}

	}


	static void go(int first, int second, int third, int forth, int fifth) {
		int tmp[][][] = new int[N][N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < N ; k++) {
					tmp[i][j][k] = map[i][j][k];
				}
			}
		}
		makeIt(first, tmp[0]);
		makeIt(second, tmp[1]);
		makeIt(third, tmp[2]);
		makeIt(forth, tmp[3]);
		makeIt(fifth, tmp[4]);


		// 전처리.
		if(tmp[0][0][0] == 0 || tmp[4][4][4] == 0) return;

		int visited[][][] = new int[N][N][N];
		visited[0][0][0] = 1;
		Queue<Tuple> q = new LinkedList<>();
		q.add(new Tuple(0,0,0));
		while(!q.isEmpty()) {
			Tuple p = q.poll();
			int r = p.r;
			int c = p.c;
			int z = p.z;

			if(r == 4 && c == 4 && z == 4) {
				if(res > visited[r][c][z]) {
					flag = true;
					res = visited[r][c][z]-1;
				}
				return;
			}

			for(int k = 0 ; k < 6 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				int nz = z + dz[k];

				if(nr < 0 || nr >= N || nc < 0 || nc >= N || nz < 0 || nz >= N || visited[nr][nc][nz] != 0 || tmp[nr][nc][nz] == 0) continue;
				visited[nr][nc][nz] = visited[r][c][z] + 1;
				q.add(new Tuple(nr,nc,nz));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int map2[][][] = new int[5][5][5];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < N ; k++) {
					map2[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		boolean check[] = new boolean[5];
		dfs(check,0,"");
		// 5중 for문
		NEXT:
		for(String x : hs) {
			String str  = x;
			for(int y = 0 ; y < 5 ; y++) {
				int num = str.charAt(y)-'0';
				for(int a = 0 ; a < 5 ; a++) {
					for(int b = 0; b< 5 ; b++) {
						map[y][a][b] = map2[num][a][b];
					}
				}
			}
			for(int i = 0 ; i < 4 ; i++) {
				for(int j = 0 ; j < 4 ; j++) {
					for(int k = 0 ; k < 4 ; k++) {
						for(int l = 0 ; l < 4 ; l++) {
							for(int m = 0 ; m < 4 ; m++) {
								go(i,j,k,l,m);
							}
						}
					}
				}
			}
		}
		if(flag) System.out.println(res);
		else System.out.println(-1);
	}
	static class Tuple {
		int r,c,z;
		Tuple(int r,int c,int z) {
			this.r = r;
			this.c = c;
			this.z = z;
		}
	}
}
