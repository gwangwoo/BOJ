import java.io.*;
import java.util.*;

public class _boj_16397_탈출 {
	static int N,T,G;
	static boolean visited[]; 
	
	static int f(int now) {
		int res = now;
		String num = String.valueOf(res);
		int first_num = num.charAt(0)-'0';
		first_num-=1;
		String new_num = "";
		if(first_num == 0) {
			new_num = num.substring(1,num.length());
		}else {
			new_num += first_num;
			new_num += num.substring(1,num.length());
		}
		return Integer.parseInt(new_num);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		visited = new boolean[100000];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(N,0));
		visited[N] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int now = p.first;
			int cnt = p.second;
			
			if(cnt > T) continue;
			if(now == G) {
				System.out.println(cnt);
				System.exit(0);;
			}
			// 1번.
			int next = now+1;
			if(next > 99999) continue;
			if(!visited[next]) {
				visited[next] = true;
				q.add(new Pair(next,cnt+1));
			}
			// 2번.
			next = now*2;
			if(next > 99999) continue;
			if(next == 0) continue;
			next = f(next);
			if(!visited[next]) {
				visited[next] = true;
				q.add(new Pair(next,cnt+1));
			}
		}
		System.out.println("ANG");
		
	}
	static class Pair {
		int first,second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

}
