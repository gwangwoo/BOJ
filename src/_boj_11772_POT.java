import java.io.*;
import java.util.*;

public class _boj_11772_POT {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			int val = Integer.parseInt(br.readLine());
			int ori = val / 10;
			int po = val % 10;
			sum += Math.pow(ori, po);
		}
		System.out.println(sum);
	}
}
