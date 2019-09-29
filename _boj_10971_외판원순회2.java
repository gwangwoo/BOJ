import java.util.*;

public class _boj_10971_외판원순회2 {
	static int N;
	static int arr[][];
	
	static int solve(int pos, int visit) {
		if(visit == (1 << N)-1) {
			if(arr[pos][0] == 0) return (int)1e9;
			else return arr[pos][0];
		}
		int ret = (int)1e9;
		for(int i = 1 ; i < N ; i++) {
			if((visit & (1 << i)) != 0) continue;
			if(arr[pos][i] == 0) continue;
			
			ret = Math.min(ret, solve(i, (visit | (1 << i))) + arr[pos][i]);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(0,1));
		
	}

}
