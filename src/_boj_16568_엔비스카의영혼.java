import java.io.*;
import java.util.*;

public class _boj_16568_엔비스카의영혼 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean visited [] = new boolean[N+1];
		int time  = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = true;
		while(!q.isEmpty()) {
			int q_size = q.size();
			while(q_size-- > 0) {
				N = q.poll();
				
				if(N == 0) {
					System.out.println(time);
					System.exit(0);
				}

				if(!visited[N-1]) {
					visited[N-1] = true;
					q.add(N-1);
				}
				if(N-a-1 >= 0 && !visited[N-a-1]) {
					visited[N-a-1] = true;
					q.add(N-a-1);
				}
				if(N-b-1 >= 0 && !visited[N-b-1]) {
					visited[N-b-1] = true;
					q.add(N-b-1);
				}
			}
			time++;
		}

	}

}
