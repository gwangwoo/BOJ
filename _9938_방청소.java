import java.io.*;
import java.util.*;
public class _9938_방청소 {
	static int p[];
	static boolean isvisited[];
	static int V,E;

	static int find(int cur) {
		if(p[cur] == cur) return cur;
		else return p[cur] = find(p[cur]);
	}

	static void union(int u,int v) {
		u = find(u);
		v = find(v);
		p[u] = v;
		System.out.println("LADICA");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		isvisited = new boolean[V+1];
		p = new int[V+1];
		
		for(int i = 1 ;  i<= V ; i++) {
			p[i] = i;
		}
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if(!isvisited[u]) {
				isvisited[u] = true;
				union(u,v);
			}else if(!isvisited[v]) {
				isvisited[v] = true;
				union(v,u);
			}else if(!isvisited[find(u)]) {
				isvisited[find(u)] = true;
				union(u,v);
			}else if(!isvisited[find(v)]) {
				isvisited[find(v)] = true;
				union(v,u);
			}else {
				System.out.println("SMECE");
			}

		}
	}
}
