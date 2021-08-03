import java.io.*;
import java.util.*;

public class _boj_11969 {
	static int N,Q;
	static int psum[][];
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		psum = new int[N+1][4];
		arr = new int[N+1][4];
		for(int i = 1 ; i <= N ; i++) {
			arr[i][Integer.parseInt(br.readLine())] = 1;
		}
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= 3 ; j++) {
				psum[i][j] += psum[i-1][j]+arr[i][j];
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0 ; i < Q ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for(int j = 1 ; j <= 3 ; j++) bw.write(psum[e][j] - psum[s-1][j]+" ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
