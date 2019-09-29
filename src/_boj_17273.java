import java.io.*;
import java.util.*;

public class _boj_17273 {
	static int N,M;
	static int front[];
	static int back[];
	
	static void swap(int idx) {
		int tmp = front[idx];
		front[idx] = back[idx];
		back[idx] = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		front = new int[N];
		back = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			front[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < N ; i++) {
			back[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < M ; i++) {
			int input = Integer.parseInt(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				if(front[j] <= input) {
					swap(j);
				}
			}
		}
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			res += front[i];
		}
		System.out.println(res);
	}
}
