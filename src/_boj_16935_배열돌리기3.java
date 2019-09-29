import java.io.*;
import java.util.*;

public class _boj_16935_배열돌리기3 {
	static int N,M,R,command;
	static int map[][];

	static void copy(int now[][] , int target[][]) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				target[i][j] = now[i][j];
			}
		}
	}

	static void print(int first[][], int second[][], int third[][], int forth[][]) {
		int tmp[][] = new int[N][M];
		for(int i = 0 ; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				tmp[i][j] = first[i][j];
			}
			for(int j = M/2 ; j < M ; j++) {
				tmp[i][j] = second[i][j-M/2];
			}
		}
		for(int i = N/2 ; i < N ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				tmp[i][j] = third[i-N/2][j];
			}
			for(int j = M/2 ; j < M ; j++) {
				tmp[i][j] = forth[i-N/2][j-M/2];
			}
		}
		copy(tmp,map);
	}

	static void print() {

		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void print5() {
		int first[][] = new int[N/2][M/2];
		int second[][] = new int[N/2][M/2];
		int third[][] = new int[N/2][M/2];
		int forth[][] = new int[N/2][M/2];
		// first;
		for(int i = 0 ; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				first[i][j] = map[i][j];
			}
		}
		// second;
		for(int i = 0 ; i < N/2 ; i++) {
			for(int j = M/2 ; j < M ; j++) {
				second[i][j-M/2] = map[i][j];
			}
		}
		// forth;
		for(int i = N/2 ; i < N ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				forth[i-N/2][j] = map[i][j];
			}
		}
		// third;
		for(int i = N/2 ; i < N ; i++) {
			for(int j = M/2 ; j < M ;j++) {
				third[i-N/2][j-M/2] = map[i][j];
			}
		}
		print(forth,first,third,second);
	}

	static void print6() {
		int first[][] = new int[N/2][M/2];
		int second[][] = new int[N/2][M/2];
		int third[][] = new int[N/2][M/2];
		int forth[][] = new int[N/2][M/2];
		// first;
		for(int i = 0 ; i < N/2 ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				first[i][j] = map[i][j];
			}
		}
		// second;
		for(int i = 0 ; i < N/2 ; i++) {
			for(int j = M/2 ; j < M ; j++) {
				second[i][j-M/2] = map[i][j];
			}
		}
		// forth;
		for(int i = N/2 ; i < N ; i++) {
			for(int j = 0 ; j < M/2 ; j++) {
				forth[i-N/2][j] = map[i][j];
			}
		}
		// third;
		for(int i = N/2 ; i < N ; i++) {
			for(int j = M/2 ; j < M ;j++) {
				third[i-N/2][j-M/2] = map[i][j];
			}
		}
		print(second,third,first,forth);
	}

	static void printDisTimer() {
		int tmp[][] = new int[M][N];
		for(int i = M-1 ; i >= 0 ; i--) {
			for(int j = 0 ; j < N ; j++) {
				tmp[M-1-i][j] = map[j][i];
			}
		}
		int val = N;
		N = M;
		M = val;
		map = new int[N][M];
		copy(tmp,map);
	}


	static void printTimer() {
		int tmp[][] = new int[M][N];
		for(int i = 0 ; i < M ; i++) {
			for(int j = N-1 ; j >= 0 ; j--) {
				tmp[i][N-1-j] = map[j][i];
			}
		}
		int val= N;
		N = M;
		M = val;
		map = new int[N][M];
		copy(tmp,map);
	}


	static void printLeftRight() {
		int tmp[][] = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = M-1 ; j >= 0 ; j--) {
				tmp[i][j] = map[i][M-1-j];
			}
		}
		copy(tmp,map);
	}


	static void printUpDown() {
		int tmp[][] = new int[N][M];
		for(int i = N-1 ; i >= 0 ; i--) {
			for(int j = 0 ; j < M ; j++) {
				tmp[N-1-i][j] = map[i][j];
			}
		}
		copy(tmp,map);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while(R-- > 0) {
			command = Integer.parseInt(st.nextToken());
			switch(command) {
			case 1:
				printUpDown();
				break;
			case 2:
				printLeftRight();
				break;
			case 3:
				printTimer();
				break;
			case 4:
				printDisTimer();
				break;
			case 5:
				print5();
				break;
			case 6:
				print6();
				break;
			}
//			print();
//			System.out.println();
		}
		print();
	}	
}