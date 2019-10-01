import java.util.*;

public class _swea_4796 {
	static int N;
	static long arr[];
	static int ans;
	static HashSet<String> hs = new HashSet<>();
	
	static boolean isPossible(int i) {
		if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) return true;
		else return false;
	}
	
	static void go(int left, int right) {
		hs.add(left+"|"+right);
		ans++;
		if(left-1 >= 0  && arr[left] > arr[left-1] && !hs.contains((left-1)+"|"+right)) {
			go(left-1,right);
		}
		if(right+1 < N && arr[right] > arr[right+1] && !hs.contains(left+"|"+(right+1))) {
			go(left,right+1);
		}
		return;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T ; tc++) {
			hs.clear();
			ans = 0;
			N = sc.nextInt();
			arr = new long[N];
			for(int i = 0 ; i < N ; i++) {
				arr[i] = sc.nextLong();
			}

			for(int i = 1 ; i < N-1 ; i++) {
				if(!isPossible(i)) continue;
				go(i-1,i+1);
			}
			System.out.println("#"+tc + " " +ans);
		
		}
	}
}
