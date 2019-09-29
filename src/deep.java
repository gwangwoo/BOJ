import java.io.*;
import java.util.*;
public class deep {

	static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	static boolean isFloat(String str) {
		try {
			Float.parseFloat(str);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		File file = new File("/Users/gguu/ML_DL_develop_with_python/lol.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNext()) {
			StringTokenizer st = new StringTokenizer(sc.next(),",");
			int N = st.countTokens();
			while(N-- > 0) {
				String str = st.nextToken();
				if(isInteger(str)) {
					System.out.print((float)Integer.parseInt(str)+",");
				}else System.out.print(str);
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
