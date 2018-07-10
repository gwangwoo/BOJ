import java.util.*;
import java.io.*;

public class _5214_환승 {
	static int N,K,M;
	static ArrayList<Integer> arl[] = new ArrayList[201005];
	static int visited[] = new int[101005];
	static int dist[] = new int[101005];
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		dist[v] = 1;
		visited[v] = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int y : arl[now]) {
				if(visited[y] == 0) {
					q.add(y);
					visited[y] = 1;
					if(y >= 100001) {
						dist[y] = dist[now];
					}else dist[y] = dist[now] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i = 0 ; i <= N+101000 ; i++) {
			arl[i] = new ArrayList<Integer>();
		}
		int str[] = new int[K];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k = 0 ; k < K ; k++) {
				str[k] = Integer.parseInt(st.nextToken());
			}
			for(int k = 0 ; k < K ; k++) {
				arl[100001+i].add(str[k]);
				arl[str[k]].add(100001+i);
			}
		}

		bfs(1);
		if(visited[N] == 0) {
			System.out.println(-1);
		}else { 
			System.out.println(dist[N]);
		}
	}
}
