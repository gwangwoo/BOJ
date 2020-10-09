import java.util.*;

public class _boj_16562 {
	static int N,M,K;
	static int p[];
	static int arr[];
	
	static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
	
	static void union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		if(arr[a] > arr[b]) p[a] = b;
		else p[b] = a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		K = sc.nextInt();
		arr = new int[N+1];
		p = new int[N+1];
		for(int i = 1 ; i <= N ; i++) p[i] = i;
		for(int i = 1 ; i <= N ; i++) arr[i] = sc.nextInt();
		for(int i = 0 ; i < M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a,b);
		}
		int ans = 0;
		for(int i = 1 ; i <= N ; i++) if(p[i] == i) ans += arr[i];
		System.out.println(ans <= K?ans:"Oh no");
	}
}
