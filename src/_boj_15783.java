import java.io.*;
import java.util.*;

public class _boj_15783 {
	static int N,M;
	static int val;
	static int person[];

	static int find(int cur) {
		if(cur == person[cur]) return cur;
		return person[cur] = find(person[cur]);
	}
	
	static void union(int u,int v) {
		u = find(u);
		v = find(v);
		if(u == v) return;
		person[v] = u;
		return;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		person = new int[N];
		for(int i = 0 ; i < N  ;i++) {
			person[i]= i;
		}

		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			union(u,v);
		}
		for(int i = 0 ; i < N ; i++) {
			if(person[i] == i) val++;
		}
		System.out.println(val);
	}

}
