import java.io.*;
import java.util.*;

public class _boj_17268 {
	static int arr[] = new int[5001];
	public static void main(String[] args) throws IOException{
		arr[2] = 2;
		arr[3] = 3;
		for(int i = 4 ; i <= 5000; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 987_654_321;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(arr[N/2]);
	}

}
