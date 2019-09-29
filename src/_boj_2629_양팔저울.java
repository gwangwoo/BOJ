import java.io.*;
import java.util.*;

public class _boj_2629_양팔저울 {
	static int N,M;
	static boolean arr[] = new boolean[40001];
	static ArrayList<Integer> arl = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		arr[0] = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int val = Integer.parseInt(st.nextToken());
			arl.add(val);
			for(int j = 15000; j >= 0 ; j--) {
				if(!arr[j]) continue;
				if(j+val > 15000) continue;
				arr[j+val] = true; 
			}
		}
		for(int i = 0 ; i < arl.size() ; i++) {
			for(int j = 0 ; j <= 15000 ; j++) {
				if(!arr[j]) continue;
				arr[Math.abs(j-arl.get(i))] = true;
			}
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(arr[num]) {
				System.out.print("Y ");
			}else System.out.print("N ");
		}

	}

}
