import java.util.*;
import java.io.*;

public class _boj_17388 {
	public static void main(String[] args) throws IOException{
		HashMap<Integer,String> hm = new HashMap<>(3);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		hm.put(Integer.parseInt(st.nextToken()), "Soongsil");
		hm.put(Integer.parseInt(st.nextToken()), "Korea");
		hm.put(Integer.parseInt(st.nextToken()), "Hanyang");
		for(int y : hm.keySet()) {
			sum += y;
		}
		if(sum >= 100) System.out.println("OK");
		else {
			int key = 200;
			for(int y: hm.keySet()) {
				key = Math.min(key, y);
			}
			System.out.println(hm.get(key));
		}
	}
}