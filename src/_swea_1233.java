import java.io.*;
import java.util.*;
public class _swea_1233 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1 ; tc <= 10 ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int res = 1;
			for(int i = 0 ; i < N ; i++) {
				String str[] = br.readLine().split(" ");
				if(str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
					if(str.length != 4) {
						res = 0;
					}
				}
			}
			System.out.println("#"+tc + " " + res);
		}
		
	}

}
