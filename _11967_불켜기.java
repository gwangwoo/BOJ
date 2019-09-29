import java.util.*;

public class _11967_불켜기 {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static boolean isOn[][];
	static ArrayList<Pair> his[][];
	static final int dy[] = {-1,0,1,0};
	static final int dx[] = {0,1,0,-1};
	
	static void bfs(int y,int x) {
		visited = new boolean[N+1][N+1];
		Queue<Pair> q = new LinkedList<>();
		visited[y][x] = true;
		q.add(new Pair(y,x));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int k = 0 ; k < 4 ; k++) {
				int ny = p.y + dy[k];
				int nx = p.x + dx[k];
				if(ny < 1 || ny > N || nx < 1 || nx > N) continue;
				// 불이 켜져서 갈수 있다면? 불을 킬수있는 방이냐 킬수 없는 방이냐로 나뉨.
				if(map[ny][nx] == 1 && !visited[ny][nx]) {
					// 불을 켰었던적이 있느냐 없었느냐? 
					if(his[ny][nx].size() > 0 && !isOn[ny][nx]) {
						for(int i = 0 ; i < his[ny][nx].size() ; i++) {
							Pair tmp = his[ny][nx].get(i);
							map[tmp.y][tmp.x] = 1;
						}
						isOn[ny][nx] = true;
						bfs(1,1);
					}
					visited[ny][nx] = true;
//					System.out.println(ny+ " " + nx);
					q.add(new Pair(ny,nx));
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][N+1];
		isOn = new boolean[N+1][N+1];
		his = new ArrayList[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				his[i][j] = new ArrayList<>();
			}
		}
		// 입력 다 받음.
		for(int i = 0 ; i < M ; i++) {
			his[sc.nextInt()][sc.nextInt()].add(new Pair(sc.nextInt(),sc.nextInt()));
		}
		map[1][1] = 1;
		isOn[1][1] = true;
		
		
		// 1,1에서 킬수있는 불은 키고 들어간다.
		if(his[1][1].size() > 0) {
			for(int i = 0 ; i < his[1][1].size() ; i++) {
				Pair tmp = his[1][1].get(i);
				map[tmp.y][tmp.x] = 1;
			}
		}else {
			System.out.println(1);
			return;
		}
		bfs(1,1);
		
		
		
		int res = 0;
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(map[i][j] == 1) res++;
			}
		}
		System.out.println(res);
	}
	static class Pair {
		int y,x;
		Pair(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}
