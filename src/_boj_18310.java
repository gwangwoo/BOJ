import java.io.*;
import java.util.*;
public class _boj_18310 {
	static int N;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.parallelSort(arr);
		if(N%2 == 0) System.out.println(arr[N/2-1]);
		else System.out.println(arr[N/2]);
	}

}
