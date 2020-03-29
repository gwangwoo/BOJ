import java.util.*;
import java.io.*;

public class _boj_1620 {
	static int N,M;
	static HashMap<String,String> hm = new HashMap<>();
	static HashMap<String,String> hm2 = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 1 ; i <= N ; i++) {
			String str = br.readLine();
			hm.put(str, i+"");
			hm2.put(i+"", str);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0 ; i < M ; i++) {
			String cmd = br.readLine();
			if(hm.containsKey(cmd)) {
				bw.write(hm.get(cmd)+"\n");
			}else bw.write(hm2.get(cmd)+"\n");
		}
		bw.flush();
	}
}
