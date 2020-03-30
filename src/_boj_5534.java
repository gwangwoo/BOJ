import java.io.*;
import java.util.*;
public class _boj_5534 {
	static int N;
	static String name;
	
	static boolean go(char arr[] ,int tmp[], int i,int idx,int val) {
		if(idx == tmp.length) {
			int diff = tmp[1] - tmp[0];
			for(int j = 2 ; j < tmp.length ; j++) {
				if(diff != tmp[j] - tmp[j-1]) return false;
			}
			return true;
		}
		for(int j = i ; j < arr.length ; j++) {
			if(arr[j] == name.charAt(val)) {
				tmp[idx] = j;
				boolean flag = go(arr,tmp,j+1,idx+1,val+1);
				if(flag) return true;
			}
		}
		return false;
	}
	
	static boolean check(char arr[]) {
		int tmp[] = new int[name.length()];
		return go(arr,tmp,0,0,0);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		name = br.readLine();
		int res = 0;
		for(int tc = 0 ; tc < N ; tc++) {
			String str = br.readLine();
			if(str.equals(name)) {
				res++;
				continue;
			}
			int val = 1;
			if(check(str.toCharArray())) {
				res++;
			}
			
		}
		System.out.println(res);
	}

}
