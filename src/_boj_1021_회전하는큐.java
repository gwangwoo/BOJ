import java.io.*;
import java.util.*;

public class _boj_1021_회전하는큐 {
	static int N,M;
	static Deque<Integer> q = new LinkedList<>();
	static ArrayList<Integer> cand = new ArrayList<>();
	
	static int find(int target , int mode) {
		int cnt = 0;
		int now = 0;
		Deque<Integer> tmpq = new LinkedList<>();
		tmpq.addAll(q);
		if(mode == 2) {		// left mode
			// 왼쪽인 경우에는 바로 큐의 첫번째값을 참조하지않는다.
			// q.pollFirst를 통해 첫번째 값을 참조하게 해준다.
			now = tmpq.pollFirst();
			while(now != target) {
				cnt++;
				tmpq.addLast(now);
				now = tmpq.pollFirst();
			}
		}else {				// right mode
			// 하지만 right의 경우 pollLast를 해주면 바로 뒷값을 참조.
			while(now != target) {
				now = tmpq.pollLast();
				cnt++;
				tmpq.addFirst(now);
				
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 1 ; i <= N ; i++) {
			q.add(i);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			cand.add(Integer.parseInt(st.nextToken()));
		}
		int res = 0;
		for(int i = 0 ; i < M ; i++) {
			int target = cand.get(i);
			int now = q.peek();
			if(target == now) {
				q.poll();
				continue;
			}
			// left || right
			int l_cnt = 0; int r_cnt = 0;
			// left : 2 , right : 3
			l_cnt = find(target,2);
			r_cnt = find(target,3);
			//System.out.println(l_cnt + " "  + r_cnt);
			// 결론적으로 left는 while문을 나가게 되면 빠지고,
			// right는 빼줘야 하므로 q.poll() 실행.
			if(l_cnt <= r_cnt) {
				now = q.pollFirst();
				while(now != target) {
					res++;
					q.addLast(now);
					now = q.pollFirst();
				}
			}else {
				while(now != target) {
					now = q.pollLast();
					res++;
					q.addFirst(now);
				}
				q.poll();
			}
		}
		System.out.println(res);
	}
}
