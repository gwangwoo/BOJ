import java.util.*;
import java.io.*;

public class _boj_16639_괄호추가하기3 {
	static int N;
	static int num[];
	static char op[];
	// 괄호 안에 여러 개의 연산자가 들어 있어도 된다.
	
	static int cal(int check[]) {
		int ans = 0;
		Deque<Integer> q = new LinkedList<>();
		q.add(num[0]);
		for(int i = 0 ; i < check.length ; i++) {
			if(check[i] == 1) {
				int now = q.pollLast();
				char opp = op[i];
				int target = num[i+1];
				switch(opp) {
				case '+':
					q.add(now+target);
					break;
				case '-':
					q.add(now-target);
					break;
				case '*':
					q.add(now*target);
					break;
				}
			}else {
				q.add((int)op[i]);
				q.add(num[i+1]);
			}
		}
		//곱셈먼저계산.
		Deque<Integer> nq = new LinkedList<>();
		nq.add(q.poll());
		while(!q.isEmpty()) {
			int tmp = q.poll();
			int opp = (char)tmp;
			int target = q.poll();
			if(opp == '*') {
				int now = nq.pollLast();
				nq.add(now*target);
			}else {
				nq.add(opp);
				nq.add(target);
			}
		}
		
		
		// 계산.
		ans = nq.pollFirst();
		while(!nq.isEmpty()) {
			int tmp = nq.poll();
			char opp = (char)tmp;
			int tar = nq.poll();
			switch(opp) {
			case '+':
				ans += tar;
				break;
			case '-':
				ans -= tar;
				break;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N/2+1];
		op = new char[N/2];
		String str = br.readLine();
		int idx1 = 0; int idx2 = 0;
		for(int i = 0 ; i < N ; i++) {
			if(i % 2 == 0) {
				num[idx1++] = str.charAt(i)-'0';
			}else {
				op[idx2++] = str.charAt(i);
			}
		}
		// 비트마스킹.
		int res = Integer.MIN_VALUE;
		for(int i = 0 ; i < (1 << N/2) ; i++) {
			int check[] = new int[N/2];
			for(int j = 0 ; j < N/2 ; j++) {
				if((i & (1 << j)) > 0) {
					check[j] = 1;
				}
			}
			int val = cal(check);
			res = Math.max(val, res);
		}
		System.out.println(res);
		
	}

}
