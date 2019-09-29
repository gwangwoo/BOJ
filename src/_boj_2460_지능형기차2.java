import java.util.*;
import java.io.*;

public class _boj_2460_지능형기차2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int now = 0;
		int MAX = 0; 
		for(int tc = 0 ; tc < 10 ; tc++) {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			now += in-out;
			MAX = Math.max(MAX, now);
		}
		System.out.println(MAX);
	}
}