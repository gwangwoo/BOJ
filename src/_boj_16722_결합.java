import java.io.*;
import java.util.*;

public class _boj_16722_결합 {
	static Paint map[];
	static final int N = 9;
	static int M;
	static HashSet<String> hs = new HashSet<>();
	static HashMap<Integer,Integer> hm;
	static ArrayList<Integer> tmp_arr = new ArrayList<>();
	// 비교메소드.
	static boolean isSame(char first, char second, char third) {
		if(first == second && second == third) return true;
		return false;
	}
	
	static boolean isDiff(char first, char second, char third) {
		if(first != second && second != third && third != first) return true;
		return false;
	}
	static boolean isSame(int first, int second, int third) {
		if(first == second && second == third) return true;
		return false;
	}
	
	static boolean isDiff(int first, int second, int third) {
		if(first != second && second != third && third != first) return true;
		return false;
	}

	static boolean isG() {
		int ret = 0;
		for(int y : hm.values()) {
			if(y == 0) return false;
		}
		return true;
	}
	
	static boolean isH(String str) {
		Paint p1 = map[str.charAt(0)-'0'];
		Paint p2 = map[str.charAt(1)-'0'];
		Paint p3 = map[str.charAt(2)-'0'];
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		if(isSame(p1.figure,p2.figure,p3.figure) || isDiff(p1.figure,p2.figure,p3.figure)) flag1 = true;
		if(!flag1) return false;
		if(isSame(p1.color,p2.color,p3.color) || isDiff(p1.color,p2.color,p3.color)) flag2 = true;
		if(!flag2) return false;
		if(isSame(p1.lad,p2.lad,p3.lad) || isDiff(p1.lad,p2.lad,p3.lad)) flag3 = true;
		if(!flag3) return false;
		return true;
	}
	
	static String sort(String str) {
		String ret = "";
		tmp_arr.clear();
		for(int i = 0 ; i < 3 ; i++) {
			tmp_arr.add(str.charAt(i)-'0');
		}
		Collections.sort(tmp_arr);
		for(int y : tmp_arr) ret += y;
		return ret;
	}

	static void dfs(int i, int cnt, String str) {
		if(cnt == 3) {
			str = sort(str);
			if(isH(str) && !hs.contains(str)) {
				hs.add(str);
			}
			return;
		}
		if(i > 9) return;
		dfs(i+1,cnt+1,str+i);
		dfs(i+1,cnt,str);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new Paint[N+1];
		StringTokenizer st;
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			String figure = st.nextToken();
			String color = st.nextToken();
			String lad = st.nextToken();
			char fig = ' ';
			char col = ' ';
			int la = 0;
			// figure
			switch(figure) {
			case "CIRCLE":
				fig = 'C';
				break;
			case "TRIANGLE":
				fig = 'T';
				break;
			case "SQUARE":
				fig = 'S';
				break;
			}

			// color;
			switch(color) {
			case "YELLOW":
				col = 'y';
				break;
			case "RED":
				col = 'r';
				break;
			case "BLUE":
				col = 'b';
				break;
			}

			// lad;
			switch(lad) {
			case "WHITE":
				la = 0;
				break;
			case "GRAY":
				la = 1;
				break;
			case "BLACK":
				la = 2;
				break;
			}

			map[i] = new Paint(fig,col,la);
		}
		// 만들 수 있는 모든 조합을 만들어보자.
		dfs(1,0,"");
//		System.out.println(hs);
		hm = new HashMap<>();
		for(String y : hs) hm.put(Integer.parseInt(y), 0);
		
		M = Integer.parseInt(br.readLine());
		int res = 0;
		boolean isGfirst = false;
		
		for(int tc = 0; tc < M ; tc++) {
			st = new StringTokenizer(br.readLine());
			if(st.countTokens() == 1) {
				if(isG() && !isGfirst) {
					res += 3;
					isGfirst = true;
				}else res -= 1;
			}else {
				st.nextToken();
				int l = st.countTokens();
				String str = "";
				while(l-- > 0) str += st.nextToken();
				str = sort(str);
				if(hs.contains(str)) {
					if(hm.get(Integer.parseInt(str)) == 0) {
						hm.put(Integer.parseInt(str), 1);
						res += 1;
					}else res -= 1;
				}else res -= 1;
			}
		}
		System.out.println(res);
	}
	static class Paint {
		char figure,color;
		int lad;
		Paint(char figure, char color, int lad) {
			this.figure = figure;
			this.color = color;
			this.lad = lad;
		}
	}
}
