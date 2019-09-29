import java.io.*;
import java.util.*;

public class _2346_풍선터뜨리기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Pair> q = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
			q.addLast(new Pair(i,Integer.parseInt(st.nextToken())));
		}
		sb.append(q.getFirst().first +" ");
		int next = q.getFirst().second;
		Pair p = q.removeFirst();
		while(!q.isEmpty()) {
			if(next > 0) {
				for(int i = 0 ; i < next-1 ; i++) {
					Pair tmp = q.removeFirst();
					q.addLast(tmp);
				}
			}else {
				next = Math.abs(next);
				for(int i = 0 ; i < next ; i++) {
					Pair tmp = q.removeLast();
					q.addFirst(tmp);
				}
			}
			Pair tmp = q.removeFirst();
			next = tmp.second;
			sb.append(tmp.first + " " );
		}
		System.out.println(sb);

	}
	static class Pair {
		int first,second;
		Pair(int first , int second) {
			this.first = first;
			this.second = second;
		}
	}
}

