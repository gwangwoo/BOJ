import java.io.*;
import java.util.*;

public class _boj_3052_나머지 {
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < 10 ; i++) hs.add(Integer.parseInt(br.readLine())%42);
		System.out.println(hs.size());
	}
}
