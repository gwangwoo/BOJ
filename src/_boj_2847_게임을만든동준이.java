import java.io.*;
import java.util.*;

public class _boj_2847_게임을만든동준이 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int res = 0;
		for(int i = N-1 ; i > 0 ; i--) {
			if(arr[i-1] >= arr[i]) {
				int val = (arr[i-1] - arr[i] +1 );
				arr[i-1] -= val;
				res += val;
			}
		}
		System.out.println(res);
		
	}

}
