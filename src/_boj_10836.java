import java.io.*;
import java.util.*;

public class _boj_10836 {
	static int M,N;
	static int map[][];
	static int init[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][M];
		for(int i = 0 ; i < M ; i++) Arrays.fill(map[i], 1);
		init = new int[M*2-1];
		Arrays.fill(init, 1);
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int cntZero = Integer.parseInt(st.nextToken());
			int cntOne = Integer.parseInt(st.nextToken());
			int cntTwo = Integer.parseInt(st.nextToken());
			int idx = cntZero;
			while(cntOne-- >0) init[idx++] += 1;
			while(cntTwo-- >0) init[idx++] += 2;
		}
		int idx = M-1;
		for(int i = 0 ; i < 2*M-1 ; i++) {
			if(i < M-1) map[idx--][0] = init[i];
			else map[0][idx++] = init[i];
		}
		
		for(int i = 1 ; i < M ; i++) {
			for(int j = 1 ; j < M ; j++) {
				map[i][j] += Math.max(map[i][j-1], Math.max(map[i-1][j-1], map[i-1][j]))-1;
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < M ; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}