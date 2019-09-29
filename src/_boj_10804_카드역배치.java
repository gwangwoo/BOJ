import java.io.*;
import java.util.*;

public class _boj_10804_카드역배치 {
	
	static int arr[] = new int[21];
	
	static void swap(int arr[] , int s,int e) {
		int tmp[] = new int[21];
		for(int i = 1 ; i <= 20 ; i++) tmp[i] = arr[i];
		int val = 0;
		for(int i = s ; i <= e ; i++) {
			arr[i] = tmp[e-val++];
		}
		
		
	}
	public static void main(String[] args) throws IOException{
		for(int i = 1 ; i <= 20 ; i++) arr[i] = i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < 10 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			swap(arr,s,e);
		}
		for(int i = 1 ; i <= 20 ; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
