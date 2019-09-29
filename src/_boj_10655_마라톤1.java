import java.io.*;
import java.util.*;

public class _boj_10655_마라톤1 {
	static int N;
	static ArrayList<Point> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr.add(new Point(r,c));
		}
		int sum = 0;
		for(int i = 0 ; i < N-1 ; i++) {
			sum += Math.abs(arr.get(i).r - arr.get(i+1).r) + Math.abs(arr.get(i).c - arr.get(i+1).c);
		}
		int MAX = 0;
		for(int i = 1 ; i < N-1 ; i++) {
			int noskipdistance = Math.abs(arr.get(i-1).r - arr.get(i).r) + Math.abs(arr.get(i).r - arr.get(i+1).r) +
					Math.abs(arr.get(i-1).c - arr.get(i).c) + Math.abs(arr.get(i).c - arr.get(i+1).c);
			int skipdistance = Math.abs(arr.get(i-1).r - arr.get(i+1).r) + Math.abs(arr.get(i-1).c - arr.get(i+1).c);
			MAX = Math.max(MAX, (noskipdistance - skipdistance)); 
		}
		System.out.println(sum - MAX);
		
		
		
	}
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
}
