import java.io.*;
import java.util.*;

public class _boj_17264 {
	static HashMap<String,Character> hm = new HashMap<>();
	static int N,M,WP,LP,bound;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		WP = Integer.parseInt(st.nextToken());
		LP = Integer.parseInt(st.nextToken());
		bound = Integer.parseInt(st.nextToken());
		int point = 0;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			hm.put(st.nextToken(), st.nextToken().charAt(0));
		}
		for(int i = 0 ; i < N ; i++) {
			String target = br.readLine();
			if(hm.containsKey(target)) {
				if(hm.get(target) == 'W') point += WP; 
				else point -= LP;
				if(point < 0) point = 0;
			}else {
				point -= LP;
				if(point < 0) point = 0;
			}
			if(point >= bound) {
				System.out.println("I AM NOT IRONMAN!!");
				System.exit(0);
			}
		}
		System.out.println("I AM IRONMAN!!");
	}
}
