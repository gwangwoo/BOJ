import java.io.*;
import java.util.*;

public class _boj_10539_수빈이와수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		arr[0] = 0;
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i <= N ; i++) arr[i] = arr[i]*i;
		for(int i = 0 ; i < N ; i++) System.out.print(arr[i+1]-arr[i]+ " ");
	}
}
