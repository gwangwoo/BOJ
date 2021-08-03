import java.io.*;
import java.util.*;

public class _boj_17203 {
	static int N,Q;
	static int arr[];
	static int psum[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		psum = new int[N+1];
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i<= N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 2 ; i <= N ; i++) {
			psum[i] = psum[i-1] + Math.abs(arr[i] - arr[i-1]);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0 ; i < Q ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			bw.write(psum[e]-psum[s]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
