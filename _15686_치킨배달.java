import java.util.*;

public class _15686_치킨배달 {
	static int N,M;
	static ArrayList<Point> person;
	static ArrayList<Point> company;
	static int map[][];
	static int min;
	static ArrayList<Integer> arr1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		person = new ArrayList<>();
		company = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					person.add(new Point(i,j));
				}else if(map[i][j] == 2) {
					company.add(new Point(i,j));
				}
			}
		}

		// 비트 마스킹
		for(int i = 0 ; i < (1<<company.size()) ; i++) {
			arr1 = new ArrayList<>();
			for(int j = 0 ; j < company.size(); j++) {
				if((i & 1<<j) != 0) {
					arr1.add(j);
				}
			}
			if(arr1.isEmpty()) continue;
			if(arr1.size() > M) continue;
			int res = 0;
			for(int j = 0 ; j < person.size() ; j++) {
				int dist = Integer.MAX_VALUE;
				for(int k = 0 ; k < arr1.size() ; k++) {
					int tmp = Math.abs(Math.abs(company.get(arr1.get(k)).x - person.get(j).x) + Math.abs(company.get(arr1.get(k)).y - person.get(j).y));
					dist = Math.min(dist, tmp);
				}
				res += dist;
			}
			min = Math.min(min, res);
		}
		System.out.println(min);

	}

	static class Point {
		int x,y;
		Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}