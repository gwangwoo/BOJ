import java.io.*;
import java.util.*;

public class _boj_14797_계산기 {
	static long K;
	static final long MAX = ((1<<63)-1);
	static String res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Long.parseLong(br.readLine());
		StringBuilder sb = new StringBuilder();
		System.out.println(5&1);
		while(K > 0) {
			if((K&1) > 0) {
				sb.append(" ]/[");
				K*=2;
			}else if((K&2) > 0) {
				sb.append(" ]+[");
				K-=2;
			}else {
				sb.append(" ]*[");
				K/=2;
			}
		}
		StringTokenizer st = new StringTokenizer(sb.toString());
		System.out.println(st.countTokens());
		System.out.println(sb.reverse().toString());

	}
}