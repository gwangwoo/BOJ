package 백준;
import java.util.*;

public class 숨바꼭질 {
	static final int MAX = 1000000;
	static int dist[] = new int[MAX];
	static boolean check[] = new boolean[MAX];

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		check[N] = true;
		dist[N] = 0;
		q.add(N);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now-1 >= 0) {
				if(check[now-1] == false) {
					q.add(now-1);
					check[now-1] = true;
					dist[now-1] = dist[now] + 1; 
				}
			}
			if(now+1 < MAX) {
				if(check[now+1] == false) {
					q.add(now+1);
					check[now+1] = true;
					dist[now+1] = dist[now] + 1; 
				}
			}
			if(now*2 < MAX) {
				if(check[now*2] == false) {
					q.add(now*2);
					check[now*2] = true;
					dist[now*2] = dist[now] + 1; 
				}
			}
		}
		System.out.println(dist[M]);
	}
}
