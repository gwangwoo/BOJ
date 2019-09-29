import java.io.*;
import java.util.*;

public class _boj_17176 {
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int num[] = new int[53];
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(N-- > 0) {
			int now = Integer.parseInt(st.nextToken());
			num[now]++;
		}
		String res = br.readLine();
		int n = res.length();
		for(int i = 0 ; i < n ; i++) {
			char now = res.charAt(i);
			if('A' <= now && now <= 'Z') {
				int val = now-'A'+1;
				num[val]--;
			}else if('a' <= now && now <= 'z') {
				int val = now-'a'+27;
				num[val]--;
			}else if(now == ' ') {
				num[0]--;
			}
		}
		for(int i = 0 ; i < 53 ; i++) {
			if(num[i] != 0) {
				System.out.println("n");
				System.exit(0);
			}
		}
		System.out.println("y");
		
	}

}
