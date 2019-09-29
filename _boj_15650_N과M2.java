import java.util.Scanner;

public class _boj_15650_N과M2 {
	static int N,M;
	static int arr[];
	static int check[];
	static int res[];
	static void dfs(int index, String str) {
		if(index == M) {
			for(int i = 0 ; i < M-1 ; i++) {
				if(res[i] >= res[i+1]) return;
			}
			System.out.println(str);
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(check[i] == 1) continue;
			check[index] = 1;
			res[index] = i+1;
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
		res = new int[M];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = i+1;
		}
			dfs(0,"");
	}

}
