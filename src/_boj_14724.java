import java.io.*;
import java.util.*;
public class _boj_14724 {
	static int N;
	public static void main(String[] args) throws IOException {
		HashMap<Integer,String> hm = new HashMap<>();
		hm.put(0, "PROBRAIN");
		hm.put(1, "GROW");
		hm.put(2, "ARGOS");
		hm.put(3, "ADMIN");
		hm.put(4, "ANT");
		hm.put(5, "MOTION");
		hm.put(6, "SPG");
		hm.put(7, "COMON");
		hm.put(8, "ALMIGHTY");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int idx = -1;
		int val = 0;
		for(int i = 0 ; i < 9 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(val < now) {
					val = now;
					idx = i;
				}
			}
		}
		System.out.println(hm.get(idx));
	}
}
