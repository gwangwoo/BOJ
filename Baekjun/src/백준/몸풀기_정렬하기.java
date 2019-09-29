package 백준;
import java.util.*;
public class 몸풀기_정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<Integer> q = new ArrayList<>();
		while(T-- >0) {
			q.add(sc.nextInt());
		}
		q.sort(null);
		for(int i = 0 ; i <q.size() ; i++)
		System.out.println(q.get(i));
	}

}
