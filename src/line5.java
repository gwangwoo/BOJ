import java.util.*;

public class line5 {
	static int N,K;	// 수빈, 동생.
	static int MAX = 500001;
	static int check[] = new int[MAX];
	static int bfs() {
		Queue<Integer> Cq = new LinkedList<>();
		Queue<Integer> Bq = new LinkedList<>();
		int time = 1;
		boolean isFind = false;
		Cq.add(K); Bq.add(N);
		while(!Cq.isEmpty()) {
			int Cq_size = Cq.size();
//			Arrays.fill(check, 0);
			while(Cq_size-- > 0) {
				int p = Cq.poll();
				if(p+time >= MAX) return -1;
				check[p+time] = 1;
				check[p] = 0;
				Cq.add(p+time);
			}
			int Bq_size = Bq.size();
			while(Bq_size-- > 0) {
				int now = Bq.poll();
				int next = now - 1;
				if(next >= 0 && check[next] == 0) {
					check[next] = 2;
					Bq.add(next);
				}else if(next >= 0 && check[next] == 1) {
					isFind = true;
					break;
				}
				next = now + 1;
				if(next < MAX && check[next] == 0) {
					check[next] = 2;
					Bq.add(next);
				}else if(next < MAX && check[next] == 1) {
					isFind = true;
					break;
				}
				next = now*2;
				if(next < MAX && check[next] == 0) {
					check[next] = 2;
					Bq.add(next);
				}else if(next < MAX && check[next] == 1) {
					isFind = true;
					break;
				}
			}
			if(isFind) {
				return time;
			}
			for(int y : Bq) {
				check[y] = 0;
			}
			time++;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if(N == K) System.out.println(0);
		else System.out.println(bfs());

	}

}


