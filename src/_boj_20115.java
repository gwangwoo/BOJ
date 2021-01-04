import java.io.*;
import java.util.*;

public class _boj_20115 {
	static int N;
	static double arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new double[N];
		double max = -1;
		PriorityQueue<Double> pq = new PriorityQueue<>();
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			max = Math.max(arr[i], max);
			pq.add(arr[i]);
		}
		while(--N > 0) {
			double a = pq.poll();
			max += a/2;
		}
		System.out.println(max);
	}
}