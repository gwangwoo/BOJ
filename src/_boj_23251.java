import java.io.*;
import java.util.*;

public class _boj_23251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int val = Integer.parseInt(br.readLine());
			bw.write(val*23+"\n");
		}
		bw.flush();
		bw.close();
	}
}
