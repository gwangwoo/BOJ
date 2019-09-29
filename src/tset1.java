import java.io.*;
import java.util.*;
public class tset1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean flag = false;
		int cnt = 0;
		int MAX = 0;
		while(N != 0) {
			int res = N % 2;
			N /= 2;
			if(res == 1 && flag == false) {
				flag = true;
			}else if(res == 1 && flag == true) {
				MAX = Math.max(cnt, MAX);
				cnt = 0;
			}else if(res == 0 && flag == true) {
				cnt++;
			}
		}
		System.out.println(MAX);
	}
}