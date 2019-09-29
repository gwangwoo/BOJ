import java.io.*;
import java.util.*;

public class _boj_1019 {
	static int N;
	static int arr[] = new int[10];

	static void cal(int val , int point) {
		while(val > 0) {
			arr[val % 10] += point;
			val /= 10;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int start = 1;
		int point = 1;
		while(start <= N) {
			// 9로 만들어주기.
			while(N % 10 != 9 && start <= N) {
				cal(N , point);
				N--;
			}
			if(start > N) break;
			// 0로 만들어주기.
			while(start % 10 != 0 && start <= N) {
				cal(start, point);
				start++;
			}
			System.out.println(start);
			start /= 10;
			N /= 10;
			for(int i = 0 ; i < 10 ; i++) {
				arr[i] += (N - start+1) * point;
			}
			point *= 10;
		}
		for(int i = 0 ; i < 10 ; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}

