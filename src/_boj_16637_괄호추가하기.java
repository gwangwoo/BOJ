import java.io.*;
import java.util.*;

public class _boj_16637_괄호추가하기 {
	static int N;
	static int num[];
	static char op[];
	static int idx1,idx2;
	
	static int go(boolean check[]) {
		int res = 0;
		Deque<Integer> q = new LinkedList<>();
		q.add(num[0]);
		for(int i = 0 ; i < check.length ; i++) {
			if(!check[i]) {
				q.add((int)op[i]);
				q.add(num[i+1]);
			}else {
				int first = q.pollLast();
				int last = num[i+1];
				switch(op[i]) {
				case '+':
					q.add(first+last);
					break;
				case '-':
					q.add(first-last);
					break;
				case '*':
					q.add(first*last);
					break;
				}
			if(i == check.length-1) break;
			if(check[i+1]) check[i+1] = false;
			}
		}
		//System.out.println(q);
		int first = q.poll();
		res = first;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			int last = q.poll();
			char opp = (char)tmp;
			switch(opp) {
			case '+':
				res += last;
				break;
			case '-':
				res -= last;
				break;
			case '*':
				res *= last;
				break;
			}
		}
		//System.out.print(" " + res);
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N/2+1];
		op = new char[N/2];
		String str = br.readLine();
		for(int i = 0 ; i < str.length(); i++) {
			if(i % 2 == 0) {
				num[idx1++] = str.charAt(i) - '0';
			}else {
				op[idx2++] = str.charAt(i);
			}
		}
		int res = Integer.MIN_VALUE;
		// 비트마스킹.
		for(int i = 0 ; i < (1 << N/2) ; i++) {
			boolean check[] = new boolean[N/2];
			for(int j = 0 ; j < N/2 ; j++) {
				if((i & (1 << j)) > 0) {
					check[j] = true;
				}
			}
			int val = go(check);
			res = Math.max(val, res);
		}
		System.out.println(res);
		
	}

}
