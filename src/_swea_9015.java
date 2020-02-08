import java.io.*;
import java.util.*;
public class _swea_9015 {
	static int N;
	static int arr[];
	
	static int f() { 
		int res = 0;
		boolean plus = false;
		boolean minus = false;
		
		for(int i = 1 ; i < N ; i++) {
			// 분기처리.
			if(!plus && !minus) {
				if(arr[i-1] < arr[i]) {
					plus = true;
				}else if(arr[i-1] > arr[i]) {
					minus = true;
				}else continue;
			}else if(plus && !minus) {
				if(arr[i] < arr[i-1]) {
					plus = false;
					res++;
				}else continue;
			}else if(!plus && minus) {
				if(arr[i] > arr[i-1]) {
					minus = false;
					res++;
				}
			}
		}
		return res+1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#"+tc +" " + f());
		}
		
	}
}
