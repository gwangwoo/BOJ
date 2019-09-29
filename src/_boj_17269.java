import java.io.*;
import java.util.*;
public class _boj_17269 {
	static int N,M;
	static String first,last;
	static HashMap<Character,Integer> hm = new HashMap<>();
	public static void main(String[] args) throws IOException {
		hm.put('A', 3); hm.put('B', 2); hm.put('C', 1); hm.put('D', 2);
		hm.put('E', 4); hm.put('F', 3); hm.put('G', 1); hm.put('H', 3);
		hm.put('I', 1); hm.put('J', 1); hm.put('K', 3); hm.put('L', 1);
		hm.put('M', 3); hm.put('N', 2); hm.put('O', 1); hm.put('P', 2);
		hm.put('Q', 2); hm.put('R', 2); hm.put('S', 1); hm.put('T', 2);
		hm.put('U', 1); hm.put('V', 1); hm.put('W', 1); hm.put('X', 2);
		hm.put('Y', 2); hm.put('Z', 1);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		first = st.nextToken(); 
		last = st.nextToken();
		String res = "";
		int MAX = Math.max(N, M);
		for(int i = 0 ; i < MAX ; i++) {
			if(i < N && i < M) {
				res += first.charAt(i);
				res += last.charAt(i);
			}else if(i >= N && i < M) {
				res += last.charAt(i);
			}else if(i < N && i >= M){
				res += first.charAt(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < res.length() ; i++) sb.append(hm.get(res.charAt(i)));
		while(sb.length() != 2) {
			StringBuilder tmp = new StringBuilder();
			for(int i = 1 ; i < sb.length() ; i++) {
				int val = (sb.charAt(i-1)-'0') + (sb.charAt(i)-'0');
				if(val >= 10) val-=10;
				tmp.append(val);
			}
			sb = new StringBuilder(tmp);
			tmp.delete(0, tmp.length());
		}
		int result = Integer.parseInt(sb.toString());
		System.out.println(result+"%");
	}

}
