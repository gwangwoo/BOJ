import java.io.*;
import java.util.*;

public class _boj_16921_로마숫자만들기2 {
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		arr.add(0); arr.add(4); arr.add(10); arr.add(20); arr.add(35);
		arr.add(56); arr.add(83); arr.add(116); arr.add(155); arr.add(198);
		arr.add(244); arr.add(292); arr.add(341); arr.add(390);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N < 14) {
			System.out.println(arr.get(N));
			return;
		}
		long cnt = (long)N - 13l;
		long res = 49l*cnt;
		res = (arr.get(13))*1l + res;
		System.out.println(res);
	}

}
