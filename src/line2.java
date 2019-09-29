import java.util.*;

public class line2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int N = str.length();
		int num_idx = N/2;
		int M = 0;
		int alpha_idx = 0;
		for(int i = 0 ; i < N ; i++) {
			if('0' <= str.charAt(i) && str.charAt(i) <= '9') {
				num_idx = i;
				M = i;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M ;) {
			if(('A' <= str.charAt(i) && str.charAt(i) <= 'Z') && ('a' <= str.charAt(i) && str.charAt(i) <= 'z')) {
				i+=2;
				sb.append(str.charAt(i)); sb.append(str.charAt(i+1));
			}else {
				sb.append(str.charAt(i));
				i+=1;
			}
			if(num_idx == N) {
				System.out.println("error");
				return;
			}
			if(str.charAt(num_idx) == '1') {
				num_idx++;
				continue;
			}
			else {
				sb.append(str.charAt(num_idx));
				num_idx++;
			}
		}
		System.out.println(sb.toString());
	}

}

