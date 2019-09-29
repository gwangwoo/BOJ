package 새출발0415;

import java.util.*;

/*
 * 2018-04-23
 * code by rhkddn5161
 * 
 */
// 첫째 줄에 F, S, G, U, D가 주어진다.
//      F: 건물의 총 층수 S: 지금있는 층 G: 스타트링크의 층 U: U층의 버튼 D: D층의 버튼.
public class 스타트링크_0423 {
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
			// 올라가기.
			int next = now + U;
			if(next > F) continue;
			if(check[next] == false) {
				dist[next] = dist[now] + 1;
				check[next] = true;
				q.add(next);
			}
			// 내려가기
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
