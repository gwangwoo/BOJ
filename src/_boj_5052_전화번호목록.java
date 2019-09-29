import java.io.*;
import java.util.*;

public class _boj_5052_전화번호목록 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		NEXT:
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> hs = new HashSet<>();
			for(int i = 0 ; i < N ;i++) {
				String str = br.readLine();
				hs.add(str);
			}
			for(String now : hs) {
				for(int j = 0 ; j < now.length() ; j++) {
					String tmp = now.substring(0,j+1);
					if(hs.contains(tmp) && !now.equals(tmp)) {
						System.out.println("NO");
						continue NEXT;
					}
				}
			}
			System.out.println("YES");
		}
	}

}
