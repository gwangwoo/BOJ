package ����;
import java.util.*;
public class ��Ǯ��_�����ϱ� {

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
