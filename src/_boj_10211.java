import java.io.*;
import java.util.*;

public class _boj_10211 {
	static int N;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
			int localSum = arr[0];
			int globalSum = arr[0];
			for(int i = 1 ; i < N ; i++) {
				if(localSum + arr[i] > arr[i]) {
					localSum += arr[i];
				}else localSum = arr[i];
				globalSum = Math.max(globalSum, localSum);
			}
			bw.write(globalSum+"\n");
		}
		bw.flush();
		bw.close();
	}
}