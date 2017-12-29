package πÈ¡ÿ;

import java.util.*;

public class ∆€¡Ò2 {
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3;
		int start = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				if (temp == 0)
					temp = 9;
				start = start * 10 + temp;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> d = new HashMap<>();
		d.put(start, 0);
		q.add(start);
		while (!q.isEmpty()) {
			int now_num = q.poll();
			String now = Integer.toString(now_num);
			int z = now.indexOf('9');
			int x = z / 3;
			int y = z % 3;
			for(int i = 0; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(3*x+y);
					next.setCharAt(3*x+y, next.charAt(3*nx+ny));
					next.setCharAt(nx*3+ny, temp);
					int num = Integer.parseInt(next.toString());
					if(!d.containsKey(num)) {
						q.add(num);
						d.put(num, d.get(now_num)+1);
					}

				}
			}
		}
		if(!d.containsKey(123456789)) {
			System.out.println(d.get(123456789));
		}else {
			System.out.println("-1");
		}
	}
}
