package �����0415;

import java.util.*;

/*
 * 2018-04-23
 * code by rhkddn5161
 * 
 */
// ù° �ٿ� F, S, G, U, D�� �־�����.
//      F: �ǹ��� �� ���� S: �����ִ� �� G: ��ŸƮ��ũ�� �� U: U���� ��ư D: D���� ��ư.
public class ��ŸƮ��ũ_0423 {
	static int F,S,G,U,D;
	static boolean check[];
	static int dist[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		check = new boolean[F+1];
		dist = new int[F+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		check[S] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			// �ö󰡱�.
			int next = now + U;
			if(next > F) continue;
			if(check[next] == false) {
				dist[next] = dist[now] + 1;
				check[next] = true;
				q.add(next);
			}
			// ��������
			next = now - D;
			if(next <= 0) continue;
			if(check[next] == false) {
				dist[next] = dist[now] + 1;
				check[next] = true;
				q.add(next);
			}
		}
		if(check[G] == false) System.out.println("use the stairs");
		else System.out.println(dist[G]);
		
	}

}
