import java.io.*;
import java.util.*;
public class _boj_4195 {
	static final int MAX = 200_001;
	static int p[] = new int[MAX];
	static int N;
	static Hash tb[] = new Hash[MAX];
	
	static void init() {
		for(int i = 0 ; i < MAX ; i++) tb[i] = new Hash();
	}
	
	static int find(String key) {
		int h = (int)hashing(key);
		int cnt = MAX;
		
		while(cnt-- > 0  && tb[h].key != null) {
			if(tb[h].key.equals(key)) return h;
			h = (h+1)%MAX;
		}
		return -1;
	}
	
	static int add(String key) {
		int h = (int)hashing(key);
		while(tb[h].key != null) {
			if(tb[h].key.equals(key)) return 0;
			h = (h+1)%MAX;
		}
		tb[h].key = key;
		return 1;
	}

	static long hashing(String str) {
		long hash = 5381;
		int l = str.length();
		for(int i = 0 ; i < l; i++) {
			hash = (((hash << 5) + hash)+(str.charAt(i))) % MAX;
		}
		return hash % MAX;
	}
	static int find(int a) {
		if(p[a] < 0) return a;
		return p[a] = find(p[a]);
	}
	static int union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a == b) return -p[a];
		int res = -(p[a] + p[b]);
		if(p[a] <= p[b]) {
			p[a] += p[b];
			p[b] = a;
		}else {
			p[b] += p[a];
			p[a] = b;
		}
		return res;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			init();
			Arrays.fill(p, -1);
			for(int i = 0 ; i <  N ; i++) {
				st = new StringTokenizer(br.readLine());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				if(find(str1) == -1) {
					add(str1);
				}
				if(find(str2) == -1) {
					add(str2);
				}
				int val1 = find(str1);
				int val2 = find(str2);
//				System.out.println(val1 + " " + val2);
				System.out.println(union(val1,val2));
			}
		}
	}
	static class Hash {
		String key;
		Hash(){};
		Hash(String key) {
			this.key = key;
		}
	}
}