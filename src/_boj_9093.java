import java.io.*;
import java.util.*;

public class _boj_9093 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = st.countTokens();
			StringBuilder tmp;
			while(N--> 0 ) {
				tmp = new StringBuilder(st.nextToken());
				sb.append(tmp.reverse()+" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
