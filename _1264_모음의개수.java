import java.util.*;
import java.io.*;

public class _1264_모음의개수 {
	static ArrayList<Character> mo = new ArrayList<>(); 

	public static void main(String[] args) throws IOException {
		mo.add('a'); mo.add('e'); mo.add('i'); mo.add('o'); mo.add('u');
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			int count = 0;
			if(str.equals("#")) break;
			str = str.toLowerCase();
			StringTokenizer st = new StringTokenizer(str,"");
			int N = st.countTokens();
			for(int i = 0 ; i < N ; i++) {
				String tmp = st.nextToken();
				for(int j = 0 ; j < tmp.length() ; j++) {
					for(int k = 0 ; k < mo.size() ; k++) {
						if(tmp.charAt(j) == mo.get(k)) count++;
					}
				}
			}
			System.out.println(count);
		}
	}

}
