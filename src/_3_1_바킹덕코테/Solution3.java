package _3_1_바킹덕코테;

import java.util.*;

public class Solution3 {

	public static int solution(String[] board) {
		int answer = 0;
		int N = board.length;

		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = board[i];
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int dr[] = {-1,-1,1,1};
		int dc[] = {-1,1,-1,1};
		for (int i = 0; i < N; i++) {
			if (answer / 2 >= Math.min(N - 1 - i, i)) {
				continue;
			}
			for (int j = 0; j < N; j++) {
				if (answer / 2 >= Math.min(N - 1 - j, j)) {
					continue;
				}

				int dir[] = new int[4];
				int maxSize = 0;

				int nr = i;
				int nc = j;
				char now = map[i][j];
				boolean flag = false;
				for(int k = 0 ; k < 4 ; k++) {
					nr = i;
					nc = j;
					while (true) {
						nr += dr[k];
						nc += dc[k];

						if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == now ) {
							dir[k]++;
						} else break;
					}
					if (dir[k] == 0 || dir[k] <= answer / 2) continue;
					else {
						if(!flag) {
							maxSize = dir[k];
							flag = true;
						}else {
							maxSize = Math.min(maxSize,dir[k]);
						}
						if(dir[3] != 0) {
							maxSize = Math.min(maxSize, dir[3]);
				            answer = Math.max(answer, maxSize*2+1);
						}
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		//		      String[] board = {"ABCBA","DABAG","EBABH","FAJAI","AKLMA"};
		String[] board = {"ABCBA","DABAG","ENABH","FAJAI","AKLMO"};
		//		String[] board2 = {"ABCBA","DABAG","ENABH","FAJAI","AKLMO"};
		System.out.println(solution(board));
		//		System.out.println(solution(board2));
	}
}

