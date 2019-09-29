import java.io.*;
import java.util.*;

public class _boj_16508_전공책 {
	static String res;
	static int N;
	static Book arr[];
	static int alpha[] = new int[26];
	static int MIN = (int)1e9;
	
	static boolean isPossible(int tmp[],String str) {
		StringTokenizer st = new StringTokenizer(str);
		int length = st.countTokens();
		for(int i = 0 ; i < length ; i++) {
			String now = st.nextToken();
			for(int j = 0 ; j < now.length() ; j++) {
				if(tmp[now.charAt(j)-'A'] == 0) continue;
				tmp[now.charAt(j)-'A']--;
			}
		}
		
		for(int i = 0 ; i < alpha.length ; i++) {
			if(tmp[i] != 0) return false;
		}
		return true;
	}
	
	static void dfs(int index, int cost, String str) {
		if(index == N) {
			int tmp[] = new int[26];
			for(int i = 0 ; i < 26 ; i++) tmp[i] = alpha[i];
			if(isPossible(tmp,str)) {
				MIN = Math.min(MIN, cost);
			}
			return;
		}
		dfs(index+1,cost+arr[index].val, str+arr[index].name+ " ");
		dfs(index+1,cost,str);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		res = br.readLine();
		for(int i = 0 ; i < res.length() ; i++) {
			char now = res.charAt(i);
			alpha[now-'A']++;
		}
		N = Integer.parseInt(br.readLine());
		arr = new Book[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken());
			String name= st.nextToken();
			arr[i] = new Book(val,name);
		}
		
		dfs(0,0,"");
		if(MIN == (int)1e9) {
			System.out.println(-1);
		}else System.out.println(MIN);

	}
	static class Book {
		int val;
		String name;
		Book(int val, String name) {
			this.val = val;
			this.name = name;
		}
	}
}
