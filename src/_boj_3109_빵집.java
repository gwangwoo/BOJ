import java.io.*;
import java.util.*;

public class _boj_3109_빵집 {
	static int N,M;
	static char map[][];
	
	static void init() {
		for(int i = 0 ; i < map.length ; i++) {
			for(int j = 0 ; j < map[i].length ; j++) {
				map[i][j] = '.';
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N+1][N+1];
		init();
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				if(str.charAt(j) == 'x') {
					map[i][j] = 'x';
					map[i][j+1] = 'x';
					map[i+1][j] = 'x';
					map[i+1][j+1] = 'x';
				}else continue;
			}
		}
		System.out.println();
		for(int i = 0 ; i < N+1 ; i++) {
			for(int j = 0  ; j < M + 1 ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}

}
