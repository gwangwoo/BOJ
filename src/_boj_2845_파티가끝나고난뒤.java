import java.io.*;
import java.util.*;

public class _boj_2845_파티가끝나고난뒤 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[5];
		for(int i = 0 ; i < 5 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < 5 ; i++) {
			System.out.print(arr[i]-num + " ");
		}
		
	}

}
