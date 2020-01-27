import java.io.*;
import java.util.*;
public class _boj_14720 {
	static int N;
	static int map[];
	static int now,res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < N ; i++) {
			if(map[i] == now) {
				now++;
				if(now == 3) now = 0;
				res++;
			}
		}
		System.out.println(res);
		
	}

}
