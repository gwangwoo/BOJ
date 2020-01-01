import java.io.*;
import java.util.*;

public class _boj_17779 {
	static int N;
	static int map[][];
	static int tmp[][];
	static int res = (int)1e9;
	
	static void fill(int r,int c,int val) {
		if(r < 0 || r >= N || c < 0 || c >= N) return;
		if(tmp[r][c] != 0) return;
		tmp[r][c] = val;
		fill(r-1,c,val);
		fill(r+1,c,val);
		fill(r,c-1,val);
		fill(r,c+1,val);
		return;
	}
	
	
	static void init() {
		for(int i = 0 ; i < N ;i++) Arrays.fill(tmp[i], 0);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		tmp = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 5번 영역 표시
		for(int y = 1 ; y < N-2 ; y++) {
			for(int x = 1; x < N-1 ; x++) {
				for(int d1 = 1 ; y+d1 < N-1 && x-d1 >= 0 ; d1++) {
					for(int d2 = 1 ; y+d1+d2 < N && x+d2 < N ; d2++) {
						init();
						//5번그리기.
						for(int i = 0 ; i <= d1 ; i++) {
							tmp[y + i][x - i] = 5;
							tmp[y+d2 + i][x+d2 - i] = 5;
						}
						for(int i = 0 ; i <= d2 ; i++) {
							tmp[y + i][x + i] = 5;
							tmp[y+d1 + i][x-d1 + i] = 5;
						}
						
						
						for(int i = y-1 ; i >= 0 ; i--) tmp[i][x] = 1;
						for(int i = x+d2+1 ; i < N ; i++) tmp[y+d2][i] = 2;
						for(int i = x-d1-1 ; i >= 0 ; i--) tmp[y+d1][i] = 3;
						for(int i = y+d1+d2+1 ; i < N ; i++) tmp[i][x-d1+d2] = 4;
						
						fill(0,0,1);
						fill(0,N-1,2);
						fill(N-1,0,3);
						fill(N-1,N-1,4);
						
						
						int people[] = new int[6];
						for(int i = 0 ; i < N ; i++) {
							for(int j = 0 ; j < N ; j++) {
								people[tmp[i][j]] += map[i][j];
							}
						}
						
						people[5] += people[0];
						int MAX = -1;
						int MIN = (int)1e9;
						for(int i = 1 ; i <= 5 ; i++) {
							MAX = Math.max(MAX, people[i]);
							MIN = Math.min(MIN, people[i]);
						}
						
						res = Math.min(res, MAX-MIN);
						
					}
				}
			}
		}
		System.out.println(res);
	}
}