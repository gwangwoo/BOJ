import java.io.*;
import java.util.*;
public class _boj_18233 {
	static int N,P,E;
	static Point arr[];

	static boolean isPossible(String str) {
		int MAX = 0;
		int MIN = 0;
		int now = 0;
		int res[] = new int[str.length()/2];
		for(int i = 0 ; i < str.length() ; i+=2) {
			if(str.charAt(i) == '0') continue;
			res[i/2] = arr[i/2].x;
			MIN += arr[i/2].x;
			MAX += arr[i/2].y;
		}
		if(MIN > E || MAX < E) return false;
		now = MIN;
		for(int i = 0 ; i < str.length() ; i+=2) {
			if(str.charAt(i) == '0') continue;
			if(now + (arr[i/2].y - arr[i/2].x) <= E) {
				now += (arr[i/2].y - arr[i/2].x);
				res[i/2] += arr[i/2].y - arr[i/2].x;
			}else {
				res[i/2] += E-now;
				now += E-now;
			}
			if(now == E) break;
		}
		if(now != E) return false; 
		for(int i = 0 ; i < res.length ; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		System.exit(0);
		return true;
	}

	static void dfs(int idx,int cnt,String str) {
		if(cnt == P) {
			if(isPossible(str)) {
				//종료.
			}
			return;
		}
		if(idx >= N || cnt > P) return;
		dfs(idx+1, cnt, str+"0 ");
		dfs(idx+1,cnt+1,str+"1 ");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new Point[N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Point(x,y);
		}
		dfs(0,0,"");
		System.out.println(-1);

	}
	static class Point {
		int x,y;
		Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
