import java.io.*;
import java.util.*;

public class _boj_16934_게임아이디 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		HashSet<String> ori = new HashSet<>();
		HashSet<String> hs = new HashSet<>();
		HashMap<String,Integer> hm = new HashMap<>();
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			if(ori.contains(str)) {
				String target = str+(hm.get(str)+1);
				int val = hm.get(str);
				val++;
				hm.remove(str);
				hm.put(str, val);
				System.out.println(target);
			}else {
				
			}
			
		}

	}

}
