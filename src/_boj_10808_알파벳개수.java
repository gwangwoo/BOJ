import java.io.*;
import java.util.*;

public class _boj_10808_알파벳개수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st ;
		int arr[] = new int[26];
		for(int i = 0 ; i < str.length(); i++) {
			arr[str.charAt(i)-'a']++;
		}
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
	}

}
