import java.io.*;
import java.util.*;

public class _boj_10809_알파벳찾기 {
	static int arr[] = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < 26 ; i++) {
			Arrays.fill(arr, -1);
		}
		String str = br.readLine();
		int val = 0;
		for(int i = 0 ; i < str.length() ; i++) {
			if(arr[str.charAt(i)-'a'] != -1) {
				val++;
				continue;
			}
			arr[str.charAt(i)-'a'] = val++;
		}
		for(int i = 0 ; i < 26 ; i++) {
			System.out.print(arr[i]+ " ");
		}
		
	}

}
