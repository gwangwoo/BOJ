import java.io.*;
import java.util.*;

public class _boj_16235_나무재테크 {
	static int N,M,K;
	static int plus_map[][];
	static int map[][];
	static int dr[] = {-1,-1,-1,0,0,1,1,1};
	static int dc[] = {-1,0,1,-1,1,-1,0,1};
	static PriorityQueue<Tree>[][] q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 우선순위 큐 생성.
		q = new PriorityQueue[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				q[i][j] = new PriorityQueue<>();
			}
		}
		// 양분 설정완료.
		plus_map = new int[N][N];
		for(int i= 0 ; i <  N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				plus_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 처음 양분 완료.
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = 5;
			}
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			q[r][c].add(new Tree(0,age));
		}

		int time = 0;
		ArrayList<Point> arr = new ArrayList<>();
		while(true) {
			if(time == K) break;
			time++;
			// 봄.
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(q[i][j].isEmpty()) continue;
					if(q[i][j].size() == 1) {
						Tree now = q[i][j].poll();
						map[i][j] -= now.age;
						if(map[i][j] < 0) {
							map[i][j] += now.age;
							arr.add(new Point(i,j,now.age));
						}else {
							q[i][j].add(new Tree(now.val+now.age , now.age+1));
						}
					}else {
						// 2개 이상이라는 말.
						Queue<Tree> tmp = new LinkedList<>();
						int q_size = q[i][j].size();
						while(q_size-- > 0) {
							Tree now = q[i][j].poll();
							map[i][j] -= now.age;
							if(map[i][j] < 0) {
								map[i][j] += now.age;
								arr.add(new Point(i,j,now.age));
							}else {
								tmp.add(new Tree(now.val+now.age , now.age+1));
							}
						}
						q[i][j].addAll(tmp);
					}
				}
			}
			// 여름.
			for(int i = 0 ; i < arr.size() ; i++) {
				Point p = arr.get(i);
				map[p.r][p.c] += (p.age/2);
			}
			arr.clear();
			// 가을.
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(q[i][j].size() == 0) continue;
					int q_size = q[i][j].size();
					Queue<Tree> tmp = new LinkedList<>();
					while(q_size-- > 0) {
						Tree p = q[i][j].poll();
						if(p.age % 5 != 0) {
							tmp.add(p);
						}else {
							for(int k = 0 ; k < 8 ; k++) {
								int nr = i + dr[k];
								int nc = j + dc[k];
								if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
								q[nr][nc].add(new Tree(0,1));
							}
							tmp.add(p);
						}
					}
					q[i][j].addAll(tmp);
				}
			}
			// 겨울.
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					map[i][j] += plus_map[i][j];
				}
			}
		}
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N  ; j++) {
				res += q[i][j].size();
			}
		}
		System.out.println(res);



	}
	static class Tree implements Comparable<Tree>{
		int val,age;
		Tree(int val, int age) {
			this.val = val;
			this.age = age;
		}
		@Override
		public int compareTo(Tree target) {
			if(this.age < target.age) return -1;
			else if(this.age > target.age) return 1;
			return 0;
		}
	}
	static class Point {
		int r,c,age;
		Point(int r,int c,int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}
	}

}
