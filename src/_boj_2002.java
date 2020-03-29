import java.io.*;
import java.util.*;

public class _boj_2002 {
	static int N;
	static HashMap<String,Boolean> hm;
	static ArrayList<String> arl;
	
	static boolean check(int idx) {
		for(int i = idx-1 ; i >= 0 ; i--) {
			if(!hm.get(arl.get(i))) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		hm = new HashMap<>();
		arl = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			hm.put(str, false);
			arl.add(str);
		}
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			String str =br.readLine();
			int idx = arl.indexOf(str);
			if(check(idx)) res++;
			hm.put(str, true);
		}
		System.out.println(res);
	}
}
