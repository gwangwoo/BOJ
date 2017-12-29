package น้มุ;

import java.util.*;

public class DSLR3 {
	static final int MAX = 10000;
	static int dist[] = new int[MAX];
	static boolean check[] = new boolean[MAX];
	static String how[] = new String[MAX];
	static int from[] = new int[MAX];
	static int first, last;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int T = sc.nextInt();
		while (T-- > 0) {
			first = sc.nextInt();
			last = sc.nextInt();
			q.clear();
			Arrays.fill(dist,0);
			Arrays.fill(check, false);
			Arrays.fill(how, null);
			Arrays.fill(from, 0);
			q.add(first);
			dist[first] = 1;
			check[first] = true;
			while (!q.isEmpty()) {
				int now = q.poll();
				int next = (2 * now) % 10000;
				if (check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = "D";
				}
				next = now - 1;
				if (now == 0)
					next = 9999;
				if (check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = "S";
				}
				next = now / 1000 + (now % 1000) * 10;
				if (check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = "L";
				}
				next = (now % 10) * 1000 + (now / 10);
				if (check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = "R";
				}
			}
			StringBuilder str = new StringBuilder();
			while (last != first) {
				str.append(how[last]);
				last = from[last];
			}
			System.out.println(str.reverse());
		}
	}
}
