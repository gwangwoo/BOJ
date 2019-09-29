import java.io.*;
import java.util.*;

public class _boj_16987_계란으로계란치기 {
	static int N;
	static Egg arr[];
	static int res;

	static void dfs(int index, int cnt) {
		if(index == N) {
			res = Math.max(cnt, res);
			return;
		}
		if(arr[index].isBreak) {
			dfs(index+1,cnt);
			return;
		}
		if(cnt == N-1) {
			res = Math.max(cnt,res);
			return;
		}
		// 가장 왼쪽에있는거 집기.
		Egg now = arr[index];
		for(int i = 0 ; i < N ; i++) {
			if(i == index) continue;
			if(arr[i].isBreak) continue;
			// 계란치기
			now.stance -= arr[i].weight;
			arr[i].stance -= now.weight;
//			System.out.println(now.stance + " " +arr[i].stance);
			if(now.stance <= 0 && arr[i].stance <= 0) {
				now.isBreak = true;
				arr[i].isBreak = true;
				dfs(index+1,cnt+2);
				now.isBreak = false;
				arr[i].isBreak = false;
			}else if(now.stance <= 0) {
				now.isBreak = true;
				dfs(index+1 , cnt+1);
				now.isBreak = false;
			}else if(arr[i].stance <= 0){
				arr[i].isBreak = true;
				dfs(index+1, cnt+1);
				arr[i].isBreak = false;;
			}else {
				dfs(index+1,cnt);
			}
			// recovery;
			now.stance += arr[i].weight;
			arr[i].stance += now.weight;
		}

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new Egg[N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[i] = new Egg(s,w,false);
		}

		dfs(0,0);
		System.out.println(res);


	}
	static class Egg {
		int stance,weight;
		boolean isBreak;
		Egg(int stance, int weight, boolean isBreak) {
			this.stance = stance;
			this.weight = weight;
			this.isBreak = isBreak;
		}
	}
}
