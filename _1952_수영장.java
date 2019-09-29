import java.io.*;
import java.util.*;

public class _1952_수영장 {
	static int cost[] = new int[4];
	static int month[] = new int[12];
	static int ans;

	static void dfs(int i, int sum) {
		if(i >= 12) {
			if(sum < ans) ans = sum;
			return;
		}

		dfs(i + 1, sum + cost[0] * month[i]);
		dfs(i + 1, sum + cost[1]);
		dfs(i + 3, sum + cost[2]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 4 ; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 12 ; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			ans = cost[3];
			dfs(0,0);
			bw.write("#" + tc + " " + ans);
			bw.write("\n");
			bw.flush();
		}
	}

}
