import java.io.*;
import java.util.*;
public class _boj_17391 {
	static int N,M;
	static int arr[];

	static long fact(int val) {
		long res = 0L;
		for(int i = 1 ; i <= val ; i++) {
			res += Math.pow(i, 2);
		}
		return res;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i]+1;
		}
		int res = M-sum;
		if(res <= 0) {
			System.out.println(0);
			return;
		}
		int space = N+1;
		if(space > res) System.out.println(res);
		else {
			int mok = res / space;
			int namerge = res % space;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i = 0 ; i < space ; i++) {
				pq.add(mok);
			}
			for(int i = 0 ; i < namerge ; i++) {
				int val = pq.poll();
				val+=1;
				pq.add(val);
			}
			int size = pq.size();
			int result = 0;
			for(int i = 0 ; i < size ; i++) {
				result += fact(pq.poll());
			}
			System.out.println(result);
		}
	}
}