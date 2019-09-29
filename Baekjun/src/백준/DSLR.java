package น้มุ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			boolean check[] = new boolean[10001];
			int dist[] = new int[10001];
			char w[] = new char[10001];
			int v[] = new int[10001];
			check[A] = true;
			dist[A] = 0;
			v[A] = 0;
			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			while(!q.isEmpty()) {
				int now = q.remove();
				int next = (now*2) % 10000;
				if(check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					w[next] = 'D';
					v[next] = now;
				}
				next = now -1;
				if(next == -1) next = 9999;
				if(check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					w[next] = 'S';
					v[next] = now;
				}
				next = (now%1000)*10 + (now/1000);
				if(check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] +1;
					w[next] = 'L';
					v[next] = now;
				}
				next = (now/10)+ (now%10)*1000;
				if(check[next] == false) {
					q.add(next);
					check[next] = true;
					dist[next] = dist[now] +1;
					w[next] = 'R';
					v[next] = now;
				}

			}
			StringBuilder str = new StringBuilder();
			while( B != A) {
				str.append(w[B]);
				B = v[B];
			}
			System.out.println(str.reverse());
		}
	}
}

