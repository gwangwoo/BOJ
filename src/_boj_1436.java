import java.io.*;
import java.util.*;
public class _boj_1436 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int arr[] = new int[10001];
		int cnt = 0;
		for(int i = 666 ; i <= 3000000 ; i++) {
			if((i+"").contains("666")) {
				arr[cnt] = i;
				cnt++;
				if(cnt == N) break;
			}
		}
		System.out.println(arr[N-1]);
	}
}
