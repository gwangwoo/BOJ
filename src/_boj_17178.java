import java.io.*;
import java.util.*;

public class _boj_17178 {
	static int N;
	static Stack<String> stk = new Stack<>();
	static ArrayList<Ticket> arr = new ArrayList<>();
	static Queue<String> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++) {
				String str = st.nextToken();
				arr.add(new Ticket(str.charAt(0),Integer.parseInt(str.substring(2))));
				q.add(str);
			}
		}
		// 답.
		Collections.sort(arr);
		int L = arr.size();
		int idx = 0;
		boolean flag = true;
		while(true) {
			if(q.isEmpty() && stk.isEmpty()) break;
			if(stk.isEmpty()) {
				String now = q.poll();
				if(now.charAt(0) == arr.get(idx).alpha && Integer.parseInt(now.substring(2))== arr.get(idx).num) {
					idx++;
					L--;
					continue;
				}else {
					stk.add(now);
					continue;
				}
			}
			else if(q.isEmpty()) {
				String now = stk.pop();
				if(now.charAt(0) == arr.get(idx).alpha && Integer.parseInt(now.substring(2)) == arr.get(idx).num) {
					idx++;
					L--;
					continue;
				}else {
					flag = false;
					break;
				}
				
			}else {
				String q_peek = q.peek();
				String stk_peek = stk.peek();
				// 큐랑 같은게 있으면, 스택이랑 같은게 있으면, 둘다 같은게 없으면 스택에 저장.
				if(q_peek.charAt(0) == arr.get(idx).alpha && Integer.parseInt(q_peek.substring(2)) == arr.get(idx).num) {
					q.poll();
					L--;
					idx++;
					continue;
				}else if(stk_peek.charAt(0) == arr.get(idx).alpha && Integer.parseInt(stk_peek.substring(2)) == arr.get(idx).num) {
					stk.pop();
					L--;
					idx++;
					continue;
				}else {
					stk.add(q.poll());
					continue;
				}
			}
		}
		if(!flag) {
			System.out.println("BAD");
		}else System.out.println("GOOD");





	}
	static class Ticket implements Comparable<Ticket>{
		char alpha;
		int num;
		Ticket(char alpha, int num) {
			this.alpha = alpha;
			this.num = num;
		}
		@Override
		public int compareTo(Ticket target) {
			if(this.alpha < target.alpha) return -1;
			else if(this.alpha > target.alpha) return 1;
			else {
				if(this.num < target.num) return -1;
				else if(this.num > target.num) return 1;
				else return 0;
			}
		}
	}
}
