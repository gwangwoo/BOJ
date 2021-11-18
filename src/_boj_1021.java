import java.io.*;
import java.util.*;

public class _boj_1021 {
	static int N,M;
	static final int LEFT = -1;
	static final int RIGHT = 1;
	
	static int cal(Deque<Integer> dq, int dir, int target, boolean plan) {
		int val = 0;
		Deque<Integer> tmpQ = new LinkedList<>(dq);
		if(dir < 0) {
			while(tmpQ.peek() != target) {
				val++;
				tmpQ.addLast(tmpQ.pollFirst());
			}
		}else if(dir > 0) {
			while(tmpQ.peek() != target) {
				val++;
				tmpQ.addFirst(tmpQ.pollLast());
			}
		}
		if(plan) {
			dq.clear();
			dq.addAll(tmpQ);
			dq.poll();
		}
		return val;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
			dq.add(i);
		}
		st = new StringTokenizer(br.readLine());
		int query = st.countTokens();
		int answer = 0;
		while(query-- > 0) {
			int demand = Integer.parseInt(st.nextToken());
			
			int now = dq.peek();
			if(demand - now == 0) {
				dq.poll();
				continue;
			}
			int moveLeftCnt = cal(dq, LEFT, demand, false);
			int moveRightCnt = cal(dq, RIGHT, demand, false);
			
			if(moveLeftCnt < moveRightCnt) {
				cal(dq,LEFT,demand,true);
				answer += moveLeftCnt;
			}else {
				cal(dq, RIGHT, demand, true);
				answer += moveRightCnt;
			}
		}
		System.out.println(answer);
	}
}
