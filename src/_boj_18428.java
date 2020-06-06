import java.io.*;
import java.util.*;

public class _boj_18428 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};
	static char map[][];
	static int N;
	static ArrayList<Point> arl;
	static ArrayList<Point> teacher;
	
	static boolean check(int r,int c,int k) {
		int nr = r + dr[k];
		int nc = c + dc[k];
		while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
			if(map[nr][nc] == 'O') break;
			if(map[nr][nc] == 'S') return false;
			nr += dr[k];
			nc += dc[k];
		}
		return true;
	}
	
	static boolean isGameOver(char map[][]) {
		int size = teacher.size();
		for(int i = 0 ; i < size ; i++) {
			Point now = teacher.get(i);
			int r = now.r;
			int c = now.c;
			for(int k = 0 ; k < 4 ; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(!check(r,c,k)) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		arl = new ArrayList<>();
		teacher = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'X') {
					map[i][j] = '.';
					arl.add(new Point(i,j));
				}else if(map[i][j] == 'T') {
					teacher.add(new Point(i,j));
				}
			}
		}
		
		int size = arl.size();
		for(int i = 0 ; i < size-2 ; i++) {
			map[arl.get(i).r][arl.get(i).c] = 'O';
			for(int j = i+1 ; j < size-1 ; j++) {
				map[arl.get(j).r][arl.get(j).c] = 'O';
				for(int k = j+1 ; k < size ; k++) {
					map[arl.get(k).r][arl.get(k).c] = 'O';
					if(isGameOver(map)) {
						System.out.println("YES");
						return;
					}
					map[arl.get(k).r][arl.get(k).c] = '.';
				}
				map[arl.get(j).r][arl.get(j).c] = '.';
			}
			map[arl.get(i).r][arl.get(i).c] = '.';
		}
		System.out.println("NO");
	}
	
	
	static class Point {
		int r,c;
		Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}

}
