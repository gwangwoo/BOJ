import java.util.*;

public class _9207_페그솔리테어 {
	static char[][] map;
	static final int dy[] = {-1,0,1,0};
	static final int dx[] = {0,1,0,-1};
	static int cnt, res, pin;
	
	static void bt(int y,int x) {
		for(int k = 0 ; k < 4 ; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			int ny2 = ny + dy[k];
			int nx2 = nx + dx[k];
			
			if(ny < 0 || ny >= 5 || nx < 0 || nx >= 9 || map[ny][nx] != 'o'
					|| ny2 < 0 || ny2 >= 5 || nx2 < 0 || nx2 >= 9 || map[ny2][nx2] != '.') continue;
			
			map[y][x] = '.';
			map[ny][nx] = '.';
			map[ny2][nx2] = 'o';
			cnt--;
			for(int i = 0 ; i < 5 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					if(map[i][j] == 'o')
						bt(i,j);
				}
			}
			
			res = Math.min(res, cnt);
			map[y][x] = 'o';
			map[ny][nx]= 'o';
			map[ny2][nx2] = '.';
			cnt++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			cnt = 0;
			res = 0;
			pin = 0;
			map = new char[5][9];
			for(int i = 0 ; i < 5 ; i++) {
				String str = sc.next();
				for(int j = 0 ; j < 9 ; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'o') cnt++;
				}
			}
			sc.nextLine();
			
			pin = cnt;
			res = cnt;
			for(int i = 0 ; i < 5 ; i++) {
				for(int j = 0 ; j < 9 ; j++) {
					if(map[i][j] == 'o') {
						bt(i,j);
					}
				}
			}
			int ans = pin - res;
			System.out.println(res + " " + ans);
		}
		
	}

}
