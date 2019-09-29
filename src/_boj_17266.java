import java.io.*;
import java.util.*;
public class _boj_17266 {
	static int N,M;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[M];
		for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		
		int left = 0; int right = 100000;
		while(left <= right) {
			int mid = (left+ right) / 2;
			
		}
			
	}

}
