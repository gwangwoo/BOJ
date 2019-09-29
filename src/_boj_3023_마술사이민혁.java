import java.io.*;
import java.util.*;

public class _boj_3023_마술사이민혁 {
	static int R,C;
	static char map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R*2][C*2];
		// 1/4 입력
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// 2/4 입력
		for(int i = 0 ; i < R ; i++) {
			for(int j = C*2-1 ; j >= C ; j--) {
				map[i][j] = map[i][C*2-1-j];
			}
		}
		// 3/4 입력
		for(int i = R*2-1 ; i >= R ; i--) {
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = map[R*2-1-i][j];
			}
		}
		// 4/4 입력
		for(int i = R*2-1; i >= R ; i--) {
			for(int j = C*2-1 ; j >= C ; j--) {
				map[i][j] = map[R*2-1-i][C*2-1-j];
			}
		}
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		
		map[r][c] = map[r][c] == '.'?'#':'.';
		
		for(int i = 0 ; i < R*2 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}

}
