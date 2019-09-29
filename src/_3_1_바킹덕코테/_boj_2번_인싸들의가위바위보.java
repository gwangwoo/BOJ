package _3_1_바킹덕코테;

import java.io.*;
import java.util.*;

public class _boj_2번_인싸들의가위바위보 {
	static int N,K;
	static int JW[];
	static boolean select[];
	static int KH[] = new int[21];
	static int MH[] = new int[21];
	static int rule[][];
	static int countJW, countKH, countMH,indexJW,indexKH,indexMH;

	static int draw(int player1, int player2) {
		if((player1 == 1 && player2 == 2) || (player1 == 2 && player2 == 1)) return 2;
		else return 3;
	}
	
	static int nextPlayer(int player1 , int player2) {
		if((player1 == 2 && player2 == 3) || (player1 == 3 && player2 == 2)) return 1;
		else if((player1 == 3 && player2 == 1) || (player1 == 1 && player2 == 3)) return 2;
		else return 3;
	}
	
	static int getHand(int player) {
		if(player == 2) return KH[indexKH++];
		else if(player == 3) return MH[indexMH++];
		return JW[indexJW++];
	}
	
	static boolean play() {
		int player1 = 1;
		int player2 = 2;
		countJW = countKH = countMH = 0;
		indexJW = indexKH = indexMH = 1;

		while(true) {
			if(countJW >= K) return true;
			if(countKH >= K || countMH >= K) return false;
			if(indexJW > N || indexKH > 20 || indexMH > 20) break;
			
			int hand1 = getHand(player1);
			int hand2 = getHand(player2);
			int winner = 0;
			if(rule[hand1][hand2] == 2) {
				winner = player1;
				player2 = nextPlayer(player1,player2);
			}else if(rule[hand1][hand2] == 0) {
				winner = player2;
				player2 = nextPlayer(player1, player2);
				player1 = winner;
			}else {
				winner = draw(player1, player2);
				player2 = nextPlayer(player1, player2);
				player1 = winner;
			}
			
			if(winner == 1) countJW++;
			else if(winner == 2) countKH++;
			else if(winner == 3) countMH++;
		}
		return false;

	}

	static void dfs(int index) {
		if(index > N) {
			if(play()) {
				System.out.println(1);
				System.exit(0);
			}
			return;
		}
		for(int i = 1 ; i <= N ;i++) {
			if(select[i]) continue;

			select[i] = true;
			JW[index] = i;
			dfs(index+1);
			select[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		rule = new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				rule[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 경희 input
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= 20 ; i++) {
			KH[i] = Integer.parseInt(st.nextToken());
		}
		// 민호 input
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= 20 ; i++) {
			MH[i] = Integer.parseInt(st.nextToken());
		}
		// 지우 input
		select = new boolean[N+1];
		JW = new int[N+1];
		dfs(1);
		System.out.println(0);

	}

}
