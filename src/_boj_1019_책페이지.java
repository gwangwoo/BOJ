import java.io.*;
import java.util.*;

public class _boj_1019_책페이지 {
	static int N;
	static int arr[] = new int[10];

	static void cal(int num,int arr[],int val) {
		while(num > 0) {
			arr[num % 10] += val;
			num /= 10;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int start = 1;
		int point = 1;

		while(start <= N) {
			// 끝자리 9로 만들기.
			while(N % 10 != 9 && start <= N) {
				cal(N,arr,point);
				N--;
			}
			if(N < start) break;
			
			// 끝자리를 0으로 만들기.
			while(start % 10 != 0 && start <= N) {
				cal(start, arr, point);
				start++;
			}
			
			start /= 10;
			N /= 10;
			
			for(int i = 0 ; i < 10 ; i++) {
				arr[i] += (N - start + 1) * point;
			}
			point *= 10;
		}
		for(int i = 0 ; i < 10 ; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
