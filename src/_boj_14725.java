import java.util.*;
import java.io.*;
public class _boj_14725 {
	static int N;
	
	static void dfs(String now, String res, TreeMap<String,Child> tree) {
		System.out.println(res + now);
		res += "--";
		
		for(String tmp : tree.get(now).child.keySet()) {
			dfs(tmp,res,tree.get(now).child);
		}
	}
	
	static TreeMap<String,Child> tree = new TreeMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			TreeMap<String,Child> tmp = tree;
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < T ; j++) {
				String str = st.nextToken();
				if(tmp.containsKey(str)) {
					tmp = tmp.get(str).child;
				}else {
					tmp.put(str, new Child());
					tmp = tmp.get(str).child;
				}
			}
		}
		for(String str : tree.keySet()) {
			dfs(str,"",tree);
		}
	}
	static class Child {
		TreeMap<String,Child> child;
		Child() {
			this.child = new TreeMap<>();
		}
	}
}
