import java.io.*;
import java.util.*;
public class _boj_17265 {
	static char map[][];
	static int N;
	static int MAX,MIN;
	static ArrayList<String> res = new ArrayList<>();
	static void dfs(int r,int c,String str) {
		if(r == N-1 && c == N-1) {
			res.add(str);
			return;
		}
		if(r+1 != N) dfs(r+1,c,str+map[r+1][c]);
		if(c+1 != N) dfs(r,c+1,str+map[r][c+1]);
	}
	
 	public static void main(String[] args) throws IOException{
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		N = Integer.parseInt(br.readLine());
 		map = new char[N][N];
 		MAX = Integer.MIN_VALUE; MIN = Integer.MAX_VALUE;
 		StringTokenizer st;
 		for(int i =0 ; i <  N ; i++) {
 			st = new StringTokenizer(br.readLine());
 			for(int j = 0 ; j < N ; j++) {
 				map[i][j] = st.nextToken().charAt(0);
 			}
 		}
 		
 		dfs(0,0,map[0][0]+"");
 		for(int i = 0 ; i < res.size() ; i++) {
 			String now = res.get(i);
 			int val = now.charAt(0)-'0';
 			for(int j = 1 ; j < now.length() ; j+=2) {
 				char mod = now.charAt(j);
 				int target = now.charAt(j+1)-'0';
 				switch(mod) {
 				case '+':
 					val += target;
 					break;
 				case '-':
 					val -= target;
 					break;
 				case '*':
 					val *= target;
 					break;
 				}
 			}
 			MAX = Math.max(MAX, val);
 			MIN = Math.min(MIN, val);
 		}
 		System.out.println(MAX + " " + MIN);
	}
 
}