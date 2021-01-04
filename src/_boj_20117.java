import java.io.*;
import java.util.*;

public class _boj_20117 {
	static int N;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.parallelSort(arr);
		Deque<Integer> dq = new LinkedList<>();
		for(int i = 0 ; i < N ; i++) {
			dq.add(arr[i]);
		}
		int cnt = N/2;
		int res = 0;
		while(cnt-- > 0) {
			int a = dq.pollFirst();
			int b = dq.pollLast();
			res += b*2;
		}
		System.out.println(dq.isEmpty()?res:res+dq.poll());
	}
}