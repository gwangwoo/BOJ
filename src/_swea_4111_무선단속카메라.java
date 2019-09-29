import java.io.*;
import java.util.*;

public class _swea_4111_무선단속카메라 {
	static int N,K;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			arr = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(arr);
			int res[] = new int[N-1];
			for(int i = 0 ; i < N-1 ; i++) {
				res[i] = arr.get(i+1) - arr.get(i);
			}
			Arrays.sort(res);
			int cnt = (N-1) - (K-1);
			int ans = 0;
			for(int i = 0 ; i < cnt ; i++) {
				ans += res[i];
			}
			System.out.println("#"+tc + " " + ans);
		}
	}

}
