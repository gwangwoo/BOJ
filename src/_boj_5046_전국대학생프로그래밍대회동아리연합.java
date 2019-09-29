import java.io.*;
import java.util.*;
// 모든 회원은 같은 호텔에서 머물러야 한다.
public class _boj_5046_전국대학생프로그래밍대회동아리연합 {
	static int N,B,H,W;		// 참가자수, 예산, 호텔의수, 고를수 있는 주의 수.
	static ArrayList<Integer> hotel[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		hotel = new ArrayList[H];
		for(int i = 0 ; i < H ; i++) hotel[i] = new ArrayList<>();
		for(int i = 0 ; i < H ; i++) {
			int cost = Integer.parseInt(br.readLine());
			hotel[i].add(cost);
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < W ; j++) {
				hotel[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int res = (int)1e9;
		for(int i = 0 ; i < H ; i++) {
			int val = (int)1e9;
			for(int j = 1 ; j <= W ; j++) {
				if(hotel[i].get(j) >= N && hotel[i].get(0)*N <= B) val = Math.min(val, hotel[i].get(0)*N);
			}
			res = Math.min(res, val);
		}
		if(res == (int)1e9) System.out.println("stay home");
		else System.out.println(res);
		
	}
}
