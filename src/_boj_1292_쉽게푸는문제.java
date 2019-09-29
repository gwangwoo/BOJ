import java.io.*;
import java.util.*;

public class _boj_1292_쉽게푸는문제 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int i = 0 ; 
		int sum = 0 ;
		while(B > 0) {
			i++;
			for(int j = 0 ; j < i ; j++) {
				A--;
				B--;
				if(A <= 0) sum += i;
				if(B == 0) break;
			}
		}
		System.out.println(sum);
		
	}

}
