import java.io.*;
import java.util.*;

public class _boj_2909_캔디구매 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long C = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		long N = 1;
		for(int i = 0 ; i < K ; i++) N *= 10;
		K = N / 10l;
		System.out.println((C + (K*5)) / (K * 10) * (K * 10));
	}
}
