package ����;
import java.util.*;

public class ���� {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3;
		int start = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				int temp = sc.nextInt();
				if(temp == 0) {
					temp = 9;
				}
				start = start*10 + temp;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer,Integer> d = new HashMap<>();
		q.add(start);
		d.put(start, 0);
		while(!q.isEmpty()) {
			int now_num = q.poll();
			String now = Integer.toString(now_num);
			int z = now.indexOf('9');
			int x = z/3;
			int y = z%3;
			//Ž��
			for(int k = 0 ; k < 4 ; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(x*3+y);
					next.setCharAt(3*x+y, next.charAt(nx*3+ny));
					next.setCharAt(nx*3+ny, temp);
					int num = Integer.parseInt(next.toString());
					if(!d.containsKey(num)) {
						q.add(num);
						d.put(num, d.get(now_num)+1);
					}
				}
			}			
		}
		if(d.containsKey(123456789)) {
			System.out.println(d.get(123456789));
		}else {
			System.out.println("-1");
		}
	}
}
