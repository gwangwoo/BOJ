import java.io.*;
import java.util.*;
public class _boj_17398 {
	static int p[];
	static int N,M,Q;
	static boolean visited[];
	static int find(int a) {
		if(p[a] < 0) return a;
		return p[a] = find(p[a]);
	}
	
	static long union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a == b) return 0;
		long result = 1L * p[a] * p[b];
		if(p[a] <= p[b]) {
			p[a] += p[b];
			p[b] = a;
		}else {
			p[b] += p[a];
			p[a] = b;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		Pair cmd[] = new Pair[M];
		visited = new boolean[M+1];
		for(int i = 1 ; i <= N ; i++) p[i] = -1;
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			cmd[i-1] = new Pair(u,v);
		}
		Stack<Integer> stk = new Stack<>();
		for(int i = 0 ; i < Q ; i++) {
			st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken())-1;
			visited[val] = true;
			stk.add(val);
		}
		for(int i = 0 ; i < M ; i++) {
			if(visited[i]) continue;
			union(cmd[i].u,cmd[i].v);
		}
		int size = stk.size(); 
		long res = 0;
		while(size-- > 0) {
			int y = stk.pop();
			res += union(cmd[y].u,cmd[y].v);
		}
		System.out.println(res);
	}
	static class Pair {
		int u,v;
		Pair(int u,int v) {
			this.u = u;
			this.v = v;
		}
	}
}