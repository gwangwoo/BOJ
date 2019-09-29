import java.io.*;
import java.util.*;
public class _boj_17406 {
	static int N,M,K;
	static int map[][];
	static Johab arr[] = new Johab[1001];
	static boolean visited[];
	static int res;

	static void move(int now[][], int target[][],int r,int c,int s,int val) {
		copy(now,target);
		// moveRight
		for(int j = c+s-val ; j > c-s+val ; j--) {
			target[r-s+val][j] = now[r-s+val][j-1];
		}
		// moveDown
		for(int i = r+s-val ; i > r-s+val ; i--) {
			target[i][c+s-val] = now[i-1][c+s-val];
		}
		// moveLeft
		for(int j = c-s+val ; j < c+s-val ; j++) {
			target[r+s-val][j] = now[r+s-val][j+1];
		}
		// moveUp
		for(int i = r-s+val ; i < r+s-val ; i++) {
			target[i][c-s+val] = now[i+1][c-s+val];
		}
		copy(target,now);
	}
	
	
	static void copy(int now[][] , int target[][]) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				target[i][j] = now[i][j];
			}
		}
	}

	static int cal(String str) {
		int val = (int)1e9;
		int tmp[][] = new int[N][M];
		int tmp2[][] = new int[N][M];
		copy(map,tmp);
		StringTokenizer st = new StringTokenizer(str);
		int cnt = st.countTokens();
		for(int i = 0 ; i < cnt ; i++) {
			int order = Integer.parseInt(st.nextToken());
			int r = arr[order].r;
			int c = arr[order].c;
			int s = arr[order].s;

			for(int j = 0 ; j < s ; j++) {
				move(tmp,tmp2,r,c,s,j);
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			int sum = 0;
			for(int j = 0 ; j < M ; j++) {
				sum += tmp[i][j];
			}
			val = Math.min(sum, val);
		}
		return val;
	}


	static void dfs(int index, String str) {
		if(index == K) {
			int val = cal(str);
			System.out.println(str);
			res = Math.min(res, val);
			return;
		}
		for(int i = 0 ; i < K ; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(index+1,str+i+" ");
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		res = (int)1e9;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int k = 0 ; k < K ; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			arr[k] = new Johab(r,c,s);
		}
		visited = new boolean[K];
		dfs(0,"");
		System.out.println(res);

	}
	static class Johab {
		int r,c,s;
		Johab(int r,int c,int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
