import java.io.*;
import java.util.*;

public class _boj_17127 {
	static int N;
	static int arr[];
	static int MAX = 0;

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int l = N-3;
		int idx = 0;
		int time = N;
		boolean flag = false;
		while(time-- > 0) {
			int sum = 0;
			for(int i = 0 ; i < N ; i++) {
				if(idx == 4) {
					flag = true;
					break;
				}
				if(i == idx) {
					int sum2 = 1;
					for(int j = i ; j < i+l ; j++) {
						sum2 *= arr[j];
					}
					sum+= sum2;
					i+=l-1;
				}else {
					sum += arr[i];
				}
			}
			if(flag) break;
			MAX = Math.max(sum, MAX);
			idx++;
		}
		System.out.println(MAX);
	}
}
