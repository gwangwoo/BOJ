import java.io.*;
import java.util.*;
public class _boj_17350 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		for(int i = 0 ; i < N ; i++) {
			hs.add(br.readLine());
		}
		boolean flag = false;
		for(String y : hs) {
			if(y.contentEquals("anj")) {
				flag = true;
				break;
			}
		}
		
		if(flag) System.out.println("뭐야;");
		else System.out.println("뭐야?");
		
	}

}
