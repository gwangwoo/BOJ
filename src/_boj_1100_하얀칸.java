import java.io.*;
import java.util.*;

public class _boj_1100_하얀칸 {
	static final int N = 8;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		for(int i = 0 ; i < 4 ; i++) {
			String str = br.readLine();
			for(int j = 0; j < N ; j+=2) {
				char now = str.charAt(j);
				if(now == 'F') res++;
			}
			str = br.readLine();
			for(int j = 1 ; j < N ; j+=2) {
				char now = str.charAt(j);
				if(now == 'F') res++;
			}
		}
		System.out.println(res);
	}
}