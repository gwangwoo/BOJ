import java.io.*;
import java.util.*;

public class _boj_17211 {
	static double happy[] = new double[2];
	static double unhappy[] = new double[2];
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 2 ; i++) {
			happy[i] = Double.parseDouble(st.nextToken());
		}
		for(int i = 0 ; i < 2 ; i++) {
			unhappy[i] = Double.parseDouble(st.nextToken());
		}
		
		double arr[][] = new double[N][2];
		arr[0][0] = M==0?happy[0]:unhappy[0];
		arr[0][1] = M==0?happy[1]:unhappy[1];
		for(int i = 1 ; i < N ; i++) {
			arr[i][0] = arr[i-1][0] * happy[0] + arr[i-1][1] * unhappy[0];
			arr[i][1] = arr[i-1][0] * happy[1] + arr[i-1][1] * unhappy[1];
		}
		
		System.out.println((int)(Math.round(arr[N-1][0]*1000)));
		System.out.println((int)(Math.round(arr[N-1][1]*1000)));
		
		
	}

}
