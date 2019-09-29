import java.util.*;

public class line4 {
	static ArrayList<Integer> arr;
	static int map[];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new ArrayList<>();
		map = new int[N+1];
		for(int i = 1 ; i <= N ; i++) map[i] = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stk = new Stack<>();
		Stack<Integer> idx_stk = new Stack<>();

		int first = map[10];
		stk.push(first);
		idx_stk.push(1);
		arr.add(-1);
		arr.add(0);
		for(int i = N-1 ; i >= 1; i--) {
			int value = map[i];
			while(!stk.isEmpty()) {
				if (value <= stk.peek()) {
					arr.add(idx_stk.peek());
					break;
				}
				stk.pop();
				idx_stk.pop();
			}
			if (stk.isEmpty()) {
				arr.add(0);
			}
			stk.push(value);
			idx_stk.push(N-i);
		}
		int res = 0;
		int a = 1;
		System.out.println(arr);
		for(int i = N ; i >= 1 ; i--) {
			if(arr.get(i) == 0) continue;
			res = Math.max(res, Math.abs(i-arr.get(i))-1);
		}
		System.out.println(res);
	}

}
