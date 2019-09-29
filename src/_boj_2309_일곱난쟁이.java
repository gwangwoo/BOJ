import java.io.*;
import java.util.*;

public class _boj_2309_일곱난쟁이 {
	static final int N = 9;
	static int arr[] = new int[N];
	
	static void dfs(int index, int cnt,int sum,String str) {
		if(sum == 100 && cnt == 7) {
			StringTokenizer st = new StringTokenizer(str);
			ArrayList<Integer> arl = new ArrayList<>();
			for(int i = 0 ; i < cnt ; i++) {
				arl.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(arl);
			for(int i = 0 ; i < cnt ; i++) {
				System.out.println(arl.get(i));
			}
			System.exit(0);
		}
		if(sum > 100 || cnt > 7 || index >= 9) return;
		
		dfs(index+1, cnt+1, sum+arr[index],str+arr[index]+" ");
		dfs(index+1, cnt, sum , str);
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());
		//Arrays.sort(arr);
		dfs(0,0,0, "");
	}
}
