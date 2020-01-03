
public class _boj_18224_V3 {
	static final int MAX = 10;
	public static void main(String[] args) {
		int map[][] = new int[MAX][MAX];
		for(int i = 0 ; i < MAX ; i++) {
			for(int j = 0 ; j < MAX ; j++) {
				if((i == 0 && j == 0) || (i == MAX-1 && j == MAX-1)) continue;
				map[i][j] = (int)(Math.random()*10) % 2;
			}
		}
		System.out.println(MAX + " " + 5);
		for(int i = 0 ; i < MAX ; i++) {
			for(int j = 0 ; j < MAX ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
