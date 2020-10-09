import java.util.*;

public class _boj_13904 {
	static ArrayList<Integer> arl[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arl = new ArrayList[1001];
		for(int i = 1; i <= 1000 ; i++) arl[i] = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			int d = sc.nextInt();
			int w = sc.nextInt();
			arl[d].add(w);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int ans = 0;
		for(int i = 1000 ; i > 0 ; i--) {
			for(int j = 0 ; j < arl[i].size() ; j++) pq.add(arl[i].get(j));
			if(!pq.isEmpty()) ans += pq.poll();
		}
		System.out.println(ans);
	}
}