import java.util.*;

public class _boj_15649_N과M {
	static int N,M;
	static int arr[];
	static int check[];
	static void dfs(int index, String str) {
		if(index == M) {
			System.out.println(str);
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(check[i] == 1) continue;
			check[index] = 1;
			dfs(index+1,str+arr[i]+ " ");
			check[index] = 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		check = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = i+1;
		}
			dfs(0,"");
	}

}
