import java.io.*;
import java.util.*;
public class _boj_14718 {
	static int N,K;
	static Person stat[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stat = new Person[N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			stat[i] = new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		int MIN = (int)1e9;
		Arrays.parallelSort(stat);
		for(int x = 0 ; x < N ; x++) {
			for(int y = 0; y < N ; y++) {
				int cnt = 0;
				for(int z = 0; z < N ; z++) {
					if(stat[z].S <= stat[x].S && stat[z].D <= stat[y].D) {
						cnt++;
					}
					if(cnt == K) {
						MIN = Math.min(MIN, stat[x].S + stat[y].D + stat[z].I);
					}
				}
			}
		}
		System.out.println(MIN);

	}
	static class Person implements Comparable<Person> {
		int S,D,I;
		Person(int S,int D,int I) {
			this.S = S;
			this.D = D;
			this.I = I;
		}
		@Override
		public int compareTo(Person target) {
			if(this.I < target.I) return -1;
			else if(this.I > target.I) return 1;
			return 0;
		}
	}
}