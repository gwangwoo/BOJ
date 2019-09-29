import java.io.*;
import java.util.*;
public class _boj_17389 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int bp = 0;
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			if(str.charAt(i) == 'O') {
				res += (i+1+bp++);
			}else bp = 0;
		}
		System.out.println(res);
	}
}