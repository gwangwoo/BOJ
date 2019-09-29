import java.io.*;
import java.util.*;

public class _swea_6731_홍익이의오델로게임 {
	static int N;
	static char map[][];
	static char target[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			target = new char[N][N];
			for(int i = 0 ; i < N ; i++) Arrays.fill(map[i], 'W');
		}
	}

}
