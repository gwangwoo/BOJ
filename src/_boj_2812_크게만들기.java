import java.io.*;
import java.util.*;

public class _boj_2812_크게만들기 {
	static int N,K;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		StringBuilder num = new StringBuilder(br.readLine());
		PriorityQueue<Pair> q = new PriorityQueue<>();
		for(int i = 0 ; i < num.length() ; i++) {
			q.add(new Pair(num.charAt(i)-'0' , i));
		}
		for(int i = 0 ; i < K ; i++) {
			Pair p = q.poll();
			int index = p.index;
			StringBuilder sb;
			sb =new StringBuilder(num.substring(0, index) + "-" + num.substring(index+1, num.length()));
			num = sb;
		}
		for(int i = 0 ; i < num.length() ;i++) {
			if(num.charAt(i) == '-') continue;
			System.out.print(num.charAt(i));
		}
		System.out.println();
	}
	static class Pair implements Comparable<Pair>{
		int val,index;
		Pair(int val, int index) {
			this.val = val;
			this.index = index;
		}
		@Override
		public int compareTo(Pair target) {
			if(this.val < target.val) return -1;
			else if(this.val > target.val) return 1;
			else {
				if(this.index < target.index) return -1;
				else if(this.index > target.index) return 1;
				else return 0;
			}
		}
	}
}
