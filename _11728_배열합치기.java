import java.util.*;

public class _11728_배열합치기 {
	static ArrayList<Long> arr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		a = sc.nextInt(); b = sc.nextInt();
		for(int i = 0 ; i < a+b ; i++) {
			arr.add(sc.nextLong());
		}
		Collections.sort(arr);
		for(int i = 0 ; i < arr.size() ; i++) System.out.print(arr.get(i) + " ");
	}

}
