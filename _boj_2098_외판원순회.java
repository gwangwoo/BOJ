import java.util.*;
import java.io.*;

public class _boj_2098_외판원순회 {
	static int arr[][];
	static int dp[][];
	static int N;
	
	static int solve(int pos, int visit) {
		if(visit == (1 << N)-1) {
			if(arr[pos][0] == 0) {
				return (int)1e9;
			}else return arr[pos][0];
		}
		if(dp[pos][visit] >= 0) {
			return dp[pos][visit];
		}
		
		int ret = (int)1e9;
		for(int i = 1 ; i < N ; i++) {
			if((visit & (1 << i)) != 0) continue;
			if(arr[pos][i] == 0) continue;
			ret = Math.min(ret, solve(i, (visit | (1 << i))) + arr[pos][i]);
		}
		dp[pos][visit] = ret;
		return dp[pos][visit];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][1<<N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int res = solve(0,1);
		bw.write(Integer.toString(res));
		bw.flush();
		
	}

}
