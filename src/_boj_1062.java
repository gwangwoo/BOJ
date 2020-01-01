import java.io.*;
import java.util.*;
public class _boj_1062 {
	static int N,K;
	static String[] words;
	static boolean word[] = new boolean[26];
	static int res;
	
	static int check() {
		int val = 0;
		for(int i = 0 ; i < words.length ; i++) {
			String now = words[i];
			boolean flag = false;
			for(int j = 0 ; j < now.length(); j++) {
				if(word[now.charAt(j)-'a'] == false) {
					flag = true;
					break;
				}
			}
			if(flag) continue;
			else val++;
		}
		return val;
	}
	
	static void dfs(int idx, int cnt) {
		if(cnt == K) {
			int val = check();
			res = Math.max(val, res);
			return;
		}
		if(idx >= 26) return;
		for(int i = idx ; i < 26 ; i++) {
			if(i == 0 || i == 2 || i == 13 || i == 19 || i == 8) continue;
			if(word[i]) continue;
			word[i] = true;
			dfs(i+1,cnt+1);
			word[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			words[i] = str;
		}
		word[0] = word['n'-'a'] = word['t'-'a'] = word['i'-'a'] = word['c'-'a'] = true;
		dfs(0,5);
		System.out.println(res);
	}
}
