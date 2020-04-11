import java.io.*;
import java.util.*;
public class _boj_18868 {
	static int M,N;
	static Point arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new Point[M][N];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = new Point(Integer.parseInt(st.nextToken()), j);
			}
		}
		int res = 0;
		for(int i = 0 ; i < M ; i++) Arrays.parallelSort(arr[i]);
		for(int i = 0 ; i < M-1 ; i++) {
			for(int j = i+1 ; j < M ; j++) {
				boolean flag = false;
				for(int k = 0 ; k < N ; k++) {
					if(arr[i][k].idx != arr[j][k].idx) {
						flag = true;
						break;
					}
				}
				if(flag) continue;
				else res++;
			}
		}
		System.out.println(res);
	}
	static class Point implements Comparable<Point>{
		int val, idx;
		Point(int val,int idx) {
			this.val = val;
			this.idx = idx;
		}
		@Override
		public int compareTo(Point target) {
			return this.val - target.val;
		}
	}
}
