import java.util.*;
import java.io.*;

public class _boj_16959_체스판여행1_v3 {
	static int N,sr,sc;
	static int dr[][] = {{-2,-2,-1,1,2,2,1,-1},{-1,-1,1,1},{-1,0,1,0}};
	static int dc[][] = {{-1,1,2,2,1,-1,-2,-2},{-1,1,1,-1},{0,1,0,-1}};
	static int mal[] = {8,4,4};
	static int map[][];
	static boolean visited[][][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					sr = i; sc = j;
				}
			}
		}
		

	}

}
