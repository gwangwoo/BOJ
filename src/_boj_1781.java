import java.util.*;

public class _boj_1781 {
	static int N;
	static ArrayList<Integer> arl[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arl = new ArrayList[200_001];
		int MAX = 0;
		for(int i = 1 ; i < 200_001 ; i++) arl[i] = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			int d = sc.nextInt();
			int c = sc.nextInt();
			MAX = Math.max(MAX, d);
			arl[d].add(c);
		}
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i = MAX ; i > 0 ; i--) {
			for(int j = 0 ; j < arl[i].size() ; j++) {
				pq.add(arl[i].get(j));
			}
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		System.out.println(ans);
	} 
}
