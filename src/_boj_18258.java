import java.io.*;
import java.util.*;
public class _boj_18258 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		StringTokenizer st;
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
			case "push":
				int val = Integer.parseInt(st.nextToken());
				q.add(val);
				break;
			case "pop":
				if(q.isEmpty()) bw.write(-1+"\n");
				else bw.write(q.poll()+"\n");
				break;
			case "size":
				bw.write(q.size()+"\n");
				break;
			case "empty":
				if(q.isEmpty()) bw.write(1+"\n");
				else bw.write(0+"\n");
				break;
			case "front":
				if(q.isEmpty()) bw.write(-1+"\n");
				else bw.write(q.peekFirst()+"\n");
				break;
			case "back":
				if(q.isEmpty()) bw.write(-1+"\n");
				else bw.write(q.peekLast()+"\n");
				break;
			}
		}
		bw.flush();
	}
}
