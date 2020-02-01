import java.io.*;
import java.util.*;
public class _boj_18312 {
	static int N,K;
	
	static int check(String str) {
		for(int i = 0 ; i < str.length() ; i++) {
			if((str.charAt(i)-'0') == K) return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int res = 0;
		for(int h = 0 ; h <= N ; h++) {
			for(int m = 0 ; m < 60 ; m++) {
				for(int s = 0 ; s < 60 ; s++) {
					String hh= "",mm ="",ss="";
					if(h / 10 == 0) hh = "0"+h;
					else hh = h+"";
					if(m / 10 == 0) mm = "0"+m;
					else mm = m+"";
					if(s / 10 == 0) ss = "0"+s;
					else ss = s+"";
					res += check(hh+mm+ss);
				}
			}
		}
		System.out.println(res);
	}
}