package 백준;
import java.util.*;

public class 소수 {
	static final int MAX = 10000;
	static int dist[] = new int[MAX];
	static boolean check[] = new boolean[MAX];
	
	public static List<Integer> getPrimeNumber() {
		List<Integer> primes = new LinkedList<>();
		primes.add(2);
		Next_Number:
			for(int i = 3 ; i < 9999; i+=2) {
				for(int n : primes) {
					if(i % n == 0) {
						continue Next_Number;
					}
				}
				primes.add(i);
			}
		return primes;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		List<Integer> PrimeNumber = new ArrayList<>();
		PrimeNumber.addAll(getPrimeNumber());
		int end = 0;
		while(T-- > 0) {
			int first = sc.nextInt();
			int last = sc.nextInt();
			Arrays.fill(check, false);
			Arrays.fill(dist, 0);
			q.clear();
			check[first] = true;
			dist[first] = 0;
			q.add(first);
			while(!q.isEmpty()) {
				int now = q.poll();
				if(now == last) {
					end = dist[now];
					break;
				}
				for(int i = 1 ; i <= 9 ; i++) {
					int next = i*1000+(now%1000);
					if(Collections.binarySearch(PrimeNumber, next) > -1) {
						if(check[next] == false) {
							q.add(next);
							check[next] = true;
							dist[next] = dist[now] + 1;
						}
					}
				}
				for(int i = 0 ; i <= 9 ; i++) {
					int next = (now/1000)*1000 + (i*100) + (now%100);
					if(Collections.binarySearch(PrimeNumber, next) > -1) {
						if(check[next] == false) {
							q.add(next);
							check[next] = true;
							dist[next] = dist[now] + 1;
						}
					}
				}
				for(int i = 0 ; i <= 9 ; i++) {
					int next = (now/100)*100 + (i*10) + (now%10);
					if(Collections.binarySearch(PrimeNumber, next) > -1) {
						if(check[next] == false) {
							q.add(next);
							check[next] = true;
							dist[next] = dist[now] + 1;
						}
					}
				}
				for(int i = 0 ; i <= 9 ; i++) {
					int next = (now/10)*10 + i;
					if(Collections.binarySearch(PrimeNumber, next) > -1) {
						if(check[next] == false) {
							q.add(next);
							check[next] = true;
							dist[next] = dist[now] + 1;
						}
					}
				}
			}
			System.out.println(end);
		}
	}
}
