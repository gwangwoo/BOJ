import java.io.*;
import java.util.*;

public class _boj_1700_멀티탭스케쥴링 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// N 은 플러그의 사이즈
		int isFool = 0;
		st = new StringTokenizer(br.readLine());
		HashSet<Integer> plug = new HashSet<>();
		ArrayList<Integer> arl = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {
			arl.add(Integer.parseInt(st.nextToken()));
		}
		int res = 0;
		for(int i = 0 ; i < M ; i++) {
			// 마지막처리.
			int now = arl.get(0);
			if(i == M-1) {
				if(plug.contains(now)) break;
				res++;
				break;
			}
			// 플러그가 비었을떄.
			if(plug.size() != N) {
				plug.add(arl.remove(0));
				continue;
			}
			// 플러그에 사용할 타겟이 존재할때.
			if(plug.contains(now)) {
				arl.remove(0);
				continue;
			}
			// 뒤로 N만큼 봐보고 사용될꺼는 빼는것을 지양한다.
			int target = 0;
			int far = 0;
			ArrayList<Integer> hs = new ArrayList<>(plug);
			for(int j = 0 ; j < N ; j++) {
				int distance = 9999;
				for(int k = 0 ; k < arl.size() ; k++) {
					if(hs.get(j) == arl.get(k)) {
						distance = k;
						break;
					}
				}
				if(distance > far) {
					target = j;
					far = distance;
				}
			}
			// 뽑기.
			hs.remove(target);
			hs.add(arl.remove(0));
			plug.clear();
			plug.addAll(hs);
			res++;
		}
		System.out.println(res);
		
	}
}
