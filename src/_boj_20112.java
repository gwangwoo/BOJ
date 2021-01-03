import java.io.*;
import java.util.*;

public class _boj_20112 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char map[][] = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		boolean flag = false;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] != map[j][i]) {
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		System.out.println(flag?"NO":"YES");
	}
}
