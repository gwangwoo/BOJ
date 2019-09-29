import java.io.*;
import java.util.*;

public class _boj_16936 {
	static int N;
	static Pair arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Pair[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			long num = Long.parseLong(st.nextToken());
			long tmp = num;
			int cnt = 0;
			while(num % 3l == 0) {
				cnt++;
				num /= 3l;
			}
			arr[i] = new Pair(cnt,tmp);
		}
		Arrays.parallelSort(arr);
		for(Pair y : arr) {
			System.out.print(y.second + " ");
		}
		
	}
	static class Pair implements Comparable<Pair>{
		long first,second;
		Pair(long first, long second) {
			this.first = first;
			this.second = second;
		}
		@Override
		public int compareTo(Pair target) {
			if(this.first > target.first) return -1;
			else if(this.first < target.first) return 1;
			else {
				if(this.second < target.second) return -1;
				else if(this.second > target.second) return 1;
				else return 0;
			}
		}
	}
}
