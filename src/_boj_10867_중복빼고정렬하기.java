import java.io.*;
import java.util.*;

public class _boj_10867_중복빼고정렬하기 {
	static int N;
	static boolean arr[] = new boolean[2001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int val = Integer.parseInt(st.nextToken())+1000;
			if(!arr[val]) {
				arr[val]= true;
			}
		}
		for(int i = 0 ; i < 2001 ; i++) {
			if(arr[i]) System.out.print((i-1000) + " ");
		}
	}

}
