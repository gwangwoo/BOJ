import java.io.*;
import java.util.*;

public class _3967_매직스타 {
	static final int dr[][] = {{1,1,1,1},{3,3,3,3},{0,1,2,3},{0,1,2,3},{1,2,3,4},{1,2,3,4}};
	static final int dc[][] = {{1,3,5,7},{1,3,5,7},{4,3,2,1},{4,5,6,7},{1,2,3,4},{7,6,5,4}};
	static boolean visited[] = new boolean[13];
	static char map[][];
	static ArrayList<Pair> arr = new ArrayList<>();

	static void go(int index, int goal) {
		
		if(index == goal) {
			for(int i = 0 ; i < 6 ; i++) {
				int sum = 0;
				for(int j = 0 ; j < 4 ; j++) {
					int r = dr[i][j];
					int c = dc[i][j];
					sum += map[r][c]-'A'+1;
				}
				
				if(sum != 26) return;
			}
			for(int i = 0 ; i < 5 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		for(int i = 1 ; i <= 12 ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				map[arr.get(index).first][arr.get(index).second] = (char)('A'+i-1);
				go(index+1,goal);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][9];
		for(int i = 0 ; i < 5 ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'x') arr.add(new Pair(i,j));
				else if(map[i][j] != '.') 
					visited[map[i][j] - 'A' + 1] = true;
			}
		}
		
		go(0,arr.size());

	}
	static class Pair {
		int first,second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
