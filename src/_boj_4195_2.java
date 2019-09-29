import java.io.*;
import java.util.*;
public class _boj_4195_2 {
	static final int MAX = 200_001;
	static int p[] = new int[MAX];
	static HashMap<String,Integer> hm = new HashMap<>();
	static int N;
	
	static int find(int a) {
		if(p[a] < 0) return a;
		return p[a] = find(p[a]);
	}
	static void union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a == b) {
			System.out.println(-p[a]);
			return;
		}
		if(p[a] <= p[b]) {
			p[a] += p[b];
			p[b] = a;
			System.out.println(-p[a]);
		}else {
			p[b] += p[a];
			p[a] = b;
			System.out.println(-p[b]);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			hm.clear();
			Arrays.fill(p, -1);
			int idx = 0;
			for(int i = 0 ; i <  N ; i++) {
				st = new StringTokenizer(br.readLine());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				if(!hm.containsKey(str1)) {
					hm.put(str1, idx++);
				}
				if(!hm.containsKey(str2)) {
					hm.put(str2, idx++);
				}
				int val1 = hm.get(str1);
				int val2 = hm.get(str2);
//				System.out.println(val1 + " " + val2);
				union(val1,val2);
//				System.out.println(-find(p[val1]));
			}
		}
	}
}