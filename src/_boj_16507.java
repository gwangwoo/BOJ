import java.io.*;
import java.util.*;

public class _boj_16507 {
	static int N,M,Q;
	static int arr[][];
	static int psum[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		psum = new int[N+1][M+1];
		
		for(int i = 1 ; i<= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ; i<= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + arr[i][j];
			}
		}
		
		for(int i = 0 ; i < Q ; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int val = psum[x2][y2] - psum[x2][y1-1] - psum[x1-1][y2] + psum[x1-1][y1-1];
			System.out.println(val / ((y2-y1+1) * (x2-x1+1)));
		}
	}
}