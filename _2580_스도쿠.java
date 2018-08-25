import java.util.*;
import java.io.*;

public class _2580_스도쿠 {
	static int map[][];
	static int cnt = 0;
	static ArrayList<Pair> arr = new ArrayList<>();

	static boolean isPromising(int r, int c, int val) {
		// 가로행 검사.
		for(int i = 0 ; i < 9 ; i++) {
			if(map[r][i] == val) return false;
		}
		// 세로행 검사.
		for(int i = 0 ; i < 9 ; i++) {
			if(map[i][c] == val) return false;
		}
		// 3*3 영역검사.
		for(int i = r/3*3 ; i < r/3*3+3 ; i++) {
			for(int j = c/3*3 ; j < c/3*3+3 ; j++) {
				if(map[i][j] == val) return false;
			}
		}
		return true;
	}

	static void go(int index,int goal) {
		if(index == goal) {
			// 정답제출.
			for(int i = 0 ; i < 9 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					System.out.print(map[i][j] + " " );
				}
				System.out.println();
			}
			System.exit(0);
		}

		Pair now = arr.get(index);
		for(int i = 1 ; i <= 9 ; i++) {
			if(isPromising(now.first, now.second,i)) {
				map[now.first][now.second] = i;
//				System.out.println(i);
				go(index+1,goal);
			}
			map[now.first][now.second] = 0;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for(int i = 0 ; i < 9 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) arr.add(new Pair(i,j));
			}
		}
		System.out.println();
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

