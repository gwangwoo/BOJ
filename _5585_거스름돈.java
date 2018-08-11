import java.io.*;
import java.util.*;

public class _5585_거스름돈 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = 1000 - N;
		
		int cnt = 0;
		while(ans >= 500) {
			ans-= 500;
			cnt++;
		}
		while(ans >= 100) {
			ans-=100;
			cnt++;
		}
		while(ans >= 50) {
			ans -= 50;
			cnt++;
		}
		while(ans >= 10) {
			ans -= 10;
			cnt++;
		}
		while(ans >= 5) {
			ans -= 5;
			cnt++;
		}
		while(ans >= 1) {
			ans -= 1;
			cnt++;
		}
		System.out.println(cnt);
	}

}
