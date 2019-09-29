import java.io.*;
import java.util.*;

public class _boj_2312_수복원하기 {
	static ArrayList<Integer> prime = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean pn[] = new boolean[100001];
		pn[0] = pn[1] = true;
		for(int i = 2 ; i*i <= 100000 ; i++) {
			if(!pn[i]) {
				for(int j = i*i ; j <= 100000 ; j+=i) {
					pn[j] = true;
				}
			}
		}

		for(int i = 2 ; i <= 100000 ; i++) {
			if(!pn[i]) {
				prime.add(i);
			}
		}
		int T = Integer.parseInt(br.readLine());
		while(T-- >0) {
			int num = Integer.parseInt(br.readLine());
			HashMap<Integer,Integer> hm = new HashMap<>();

			for(int i = 0 ; ; ) {
				if(num % prime.get(i) == 0) {
					num /= prime.get(i);
					if(!hm.containsKey(prime.get(i))) {
						hm.put(prime.get(i), 1);
					}else {
						int cnt = hm.get(prime.get(i));
						hm.remove(prime.get(i));
						hm.put(prime.get(i), ++cnt);
					}
					if(num == 1) break;
				}else {
					i++;
				}
			}
			ArrayList<Integer> key = new ArrayList<>(hm.keySet());
			ArrayList<Integer> value = new ArrayList<>(hm.values());
			ArrayList<Pair> arr = new ArrayList<>();
			for(int i = 0 ; i < hm.size() ; i++) {
				arr.add(new Pair(key.get(i),value.get(i)));
			}
			Collections.sort(arr);
			for(int i = 0 ; i < arr.size() ; i++) {
				System.out.println(arr.get(i).first + " " + arr.get(i).last);
			}
		}

	}
	static class Pair implements Comparable<Pair>{
		int first,last;
		Pair(int first,int last) {
			this.first = first;
			this.last = last;
		}
		@Override
		public int compareTo(Pair target) {
			if(this.first < target.first) return -1;
			else if(this.first > target.first) return 1;
			return 0;
		}
	}
}
