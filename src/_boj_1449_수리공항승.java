import java.io.*;
import java.util.*;

public class _boj_1449_수리공항승 {
	static int N,L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		boolean check[] = new boolean[3001];
		ArrayList<Integer> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			if(check[arr.get(i)]) continue;
			for(int j = arr.get(i) ; j < arr.get(i)+L ; j++) {
				check[j] = true;
			}
			res+=1;
		}
		System.out.println(res);
	}

}
