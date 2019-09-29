import java.io.*;
import java.util.*;

public class _boj_16928_뱀과사다리게임 {
	static int N,M;
	static int map[]= new int[101];
	static boolean check[] = new boolean[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N+M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u] = v;
		}
		int res = 0;
		Queue<Point> q = new LinkedList<>();
		check[1] = true;
		q.add(new Point(1,0));
		// 주사위 1부터 6까지 구현해주자.
		// 만약, 주사위를 굴린 결과가 100번 칸을 넘어가는 경우에는 이동할 수 없다.
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int cnt = p.cnt;
			
			if(r == 100) {
				res = cnt;
				break;
			}
			
			for(int i = 1 ; i <= 6 ; i++) {
				int next = r+i;
				if(next > 100) break;
				if(check[next]) continue;
				if(map[next] == 0) {
					q.add(new Point(next,cnt+1));
					check[next] = true;
				}else {
					q.add(new Point(map[next], cnt+1));
					check[next] = true;
					check[map[next]] = true;
				}
			}
		}
		System.out.println(res);
		
	}
	static class Point {
		int r,cnt;
		Point(int r,int cnt) {
			this.r = r;
			this.cnt = cnt;
		}
	}

}
