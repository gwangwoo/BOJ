import java.io.*;
import java.util.*;

public class _boj_2594 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int arr[] = new int[2401];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			int first_h = first / 100;
			int first_m = first % 100;
			int last_h = last / 100;
			int last_m = last % 100;
			if(first_m - 10 < 0) {
				first_h -= 1;
				first_m += 50;
			}else first_m -= 10;
			first = first_h*100+first_m;
			if(last_m + 10 >= 60) {
				last_m -= 50;
				last_h += 1;
			}else last_m += 10;
			last = last_h*100+last_m;
			
			for(int j = first ; j < last ; j++) {
				if(j % 100 >= 60) continue;
				arr[j] = -1;
			}
		}
		arr[2200] = -1;
		int res = 0;
		int MAX = 0;
		for(int i = 1000 ; i <= 2200 ; i++) {
			if((i % 100) == 60) {
				i+=39;
				continue;
			}
			if(arr[i] == 0) res++;
			else if(res != 0 && arr[i] == -1) {
//				res++;
				MAX = Math.max(res, MAX);
				res = 0;
			}
		}
		MAX = Math.max(MAX, res);
		System.out.println(MAX);
	}

}
