import java.util.*;
import java.io.*;
public class _swea_1860 {
	static int N,M,K;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.parallelSort(arr);
			int res = 0;
			int use = 0;
			boolean flag = false;
			for(int i = 0 ; i < N ; i++) {
				int ctime = arr[i];
				res = ((ctime/M)*K-use);
				if(res > 0) use++;
				else {
					flag = true;
					break;
				}
			}
			if(flag) System.out.println("#"+tc + " " + "Impossible");
			else System.out.println("#"+tc + " " + "Possible");
			
		}
		
	
	
	
	
	}
}