import java.io.*;
import java.util.*;
public class _boj_17504 {
	static int N;

	static Fountain go(StringTokenizer st) {
		if(st.countTokens() == 1) {
			return new Fountain(1,Long.parseLong(st.nextToken()));
		}else {
			long now = Long.parseLong(st.nextToken());
			Fountain target = go(st);
			long bottom = now * target.bottom;
			target.top += bottom;
			// 나눠지는 지 확인.
			if(target.top % target.bottom == 0) {
				target.top /= target.bottom;
				target.bottom = 1;
			}
			// swap 해야댐.
			long tmp = target.top;
			target.top = target.bottom;
			target.bottom = tmp;
			return target;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Fountain res = go(st);
		System.out.println((res.bottom-res.top) + " " + res.bottom);
	}
	static class Fountain {
		long top,bottom;
		Fountain(long top, long bottom) {
			this.top = top;
			this.bottom = bottom;
		}
	}
}
