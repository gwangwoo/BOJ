import java.io.*;
import java.util.*;

public class _boj_20114 {
	static int N,H,W;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W*N];
		for(int i = 0 ; i < H ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < W*N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < W*N ; i+=W) {
			boolean flag = false;
			for(int j = 0 ; j < H ; j++) {
				for(int k = 0+i; k < i+W ; k++) {
					if(map[j][k] != '?') {
						sb.append(map[j][k]);
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			if(!flag) sb.append("?");
		}
		System.out.println(sb.toString());
	}
}