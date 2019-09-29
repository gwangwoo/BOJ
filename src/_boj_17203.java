import java.io.*;
import java.util.*;

public class _boj_17203 {
	static int N,M;
	static int arr[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken())-1;
			int r = Integer.parseInt(st.nextToken())-1;
			int sum = 0;
			for(int i = l+1 ; i <= r ; i++) {
				sum += Math.abs(arr[i]-arr[i-1]);
			}
			System.out.println(sum);
		}
	}
}
