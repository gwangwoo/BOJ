import java.io.*;
import java.util.*;

public class _boj_12840 {
	static int H,M,S,T;
	
	static void setting() {
		// 초 관리.
		if(S < 0) {
			M--;
			S = S + 60;
		}else if(S > 59) {
			M++;
			S = S - 60;
		}
		// 분 관리.
		if(M < 0) {
			H--;
			M = M + 60;
		}else if(M > 59) {
			H++;
			M = M - 60;
		}
		// 시 관리.
		if(H < 0) {
			H += 24;
		}else if(H > 23) {
			H -= 24;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int value = 0;
			if(cmd != 3) value = Integer.parseInt(st.nextToken());
			if(cmd == 1) {
				// 시계를 앞으로 c초 돌린다.
				H += ((value / 3600) % 24);
				value %= 3600;
				M += value / 60;
				value %= 60;
				S += value;
				setting();
			}else if(cmd == 2) {
				// 시계를 뒤로 c초 돌린다.
				H -= ((value / 3600) % 24);
				value %= 3600;
				M -= value / 60;
				value %= 60;
				S -= value;
				setting();
			}else if(cmd == 3) {
				// 출력
				System.out.println(H + " " + M + " " + S);
			}
		}
		
	}

}
