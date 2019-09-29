import java.io.*;
import java.util.*;

public class _boj_2804_크로스워드만들기 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String first = st.nextToken();
		String second = st.nextToken();
		// first 가로 second 세로.
		int first_index = -1;
		int second_index = -1;
		int N = first.length();
		int M = second.length();
		boolean isFind = false;
		for(int i = 0 ; i < N ; i++) {
			for(int j =0  ; j < M ; j++) {
				if(first.charAt(i) == second.charAt(j)) {
					first_index =i;
					second_index = j;
					isFind = true;
					break;
				}
			}
			if(isFind) break;
		}
		char map[][] = new char[M][N];
		for(int i = 0 ; i < M ; i++) Arrays.fill(map[i], '.');
		for(int i = 0 ; i < M ; i++) map[i][first_index] = second.charAt(i);
		for(int j = 0 ; j < N ; j++) map[second_index][j] = first.charAt(j);
		
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
