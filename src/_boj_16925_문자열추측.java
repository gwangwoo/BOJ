import java.io.*;
import java.util.*;

public class _boj_16925_문자열추측 {
	static int N;
	static ArrayList<String> arr;
	static int check[];
	static int cnt[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		int M = 2*N-2;
		check = new int[M];
		cnt = new int[M];
		for(int i = 0 ; i < M ; i++) {
			arr.add(br.readLine());
		}
		// 2중 포문을 사용해서 서로 같은것은 숫자를 넣어주자.
		int value = 0;
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(i == j) continue;
				if(arr.get(i).equals(arr.get(j))) {
					if(cnt[i] != 0) continue;
					cnt[i] = cnt[j] = ++value;
				}
			}
		}
		// 가장 긴것과 가장 짧은 애를 찾아서 앞뒤 뒤앞으로 붙여보자.
		int sdx1 = 0 , sdx2 = 0 ,ldx1 = 0;
		boolean flag2 = false;
		for(int i = 0 ; i < M ; i++) {
			if(arr.get(i).length() == N-1) ldx1 = i;
			else if(!flag2 && arr.get(i).length() == 1) {
				sdx1 = i;
				flag2 = true;
			}else if(arr.get(i).length() == 1) sdx2 = i;
		}
		// 만들수있는 조합 만들어봄 aabab ababa aabab ababa
		ArrayList<String> res = new ArrayList<>();
		res.add(arr.get(sdx1)+arr.get(ldx1));
		res.add(arr.get(ldx1) + arr.get(sdx1));
		res.add(arr.get(sdx2) + arr.get(ldx1));
		res.add(arr.get(ldx1) + arr.get(sdx2));
		int ans_idx = -1;
		NEXT:
			for(int i = 0 ; i < res.size() ; i++) {
				for(int j = 0 ; j < M ; j++) {
					String now = arr.get(j);
					// 앞뒤만 비교해주면 됨.
					// 앞 비교.
					boolean flag = false;
					// 1은 접두사 2는 접미사.
					for(int k = 0 ; k < now.length() ; k++) {
						if(now.charAt(k) != res.get(i).charAt(k)) {
							flag = true;
							break;
						}
					}
					if(!flag) {
						if(check[j] == 0) check[j] = 1;
						else check[j] = 2;
						continue;
					}
					// 뒤 비교.
					boolean fflag = false;
					for(int k = now.length()-1,x = N-1 ; k >= 0 ; k-- , x--) {
						if(now.charAt(k) != res.get(i).charAt(x)) {
							fflag = true;
							break;
						}
					}
					if(!fflag) {
						if(check[j] == 0) check[j] = 2;
						else check[j] = 1;
						continue;
					}
					// 소속되지 않았다는 증거.
					Arrays.fill(check, 0);
					continue NEXT;
				}
				boolean flagg = false;
				for(int k = 0 ; k < M ; k++) {
					if(check[k] == 0) {
						flagg = true;
					}
				}
				if(!flagg) {
					ans_idx = i;
					break;
				}
			}
		System.out.println(res.get(ans_idx));
		for(int i = M-1 ; i >= 0 ; i--) {
			if(cnt[i] == 0) continue;
			check[i] = 2;
			for(int j = i-1 ; j >= 0 ; j--) {
				if(cnt[i] == cnt[j]) {
					cnt[j] = 0;
					break;
				}
			}
				
		}
		for(int i = 0 ; i < M ; i++) {
			if(check[i] == 2) System.out.print("S");
			else System.out.print("P");
		}
		System.out.println();
		//System.out.println(res.get(ans_idx));

	}

}
