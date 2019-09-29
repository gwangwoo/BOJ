import java.io.*;
import java.util.*;

public class _boj_17206 {
	static int T;
	static int N;
	static long arr[] = new long[80001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		
		for(int i = 3 ; i <= 80000 ; i++) {
			if(i % 3 == 0 || i % 7 == 0) {
				arr[i] = arr[i-1] + i;
			}else arr[i] = arr[i-1];
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(T-- > 0) {
			int now = Integer.parseInt(st.nextToken());
			bw.write(arr[now]+"\n");
		}
		bw.flush();
	}

}
