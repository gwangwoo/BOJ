package น้มุ;

import java.util.*;

public class DSLR2 {
	static final int MAX = 10000;
	static int dist[] = new int[MAX];
	static boolean check[] = new boolean[MAX];
	static int from[] = new int[MAX];
	static String how[] = new String[MAX];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		while(T-- >0) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			Arrays.fill(dist, 0);
			Arrays.fill(check, false);
			Arrays.fill(from, 0);
			Arrays.fill(how, null);
			q.add(A);
			while(!q.isEmpty()) {
				int now = q.remove();
				int next = (now*2) % 10000;
				if(check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					how[next] = "D";
					from[next] = now;
				}
				next = now-1;
				if(next == -1)
					next = 9999;
				if(check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					how[next] = "S";
					from[next] = now;
				}
				next = (now/1000) + (now%1000)*10;
				if(check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					how[next] = "L";
					from[next] = now;
				}
				next = (now%10)*1000 + (now/10);
				if(check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					how[next] = "R";
					from[next] = now;
				}
			}
			StringBuilder str = new StringBuilder();
			while( B != A) {
				str.append(how[B]);
				B = from[B];
			}
			System.out.println(str.reverse());
		}
	}
}