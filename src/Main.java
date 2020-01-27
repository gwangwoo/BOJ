import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arl = new ArrayList<>();
		int cnt = 0;
		while(cnt != 6) {
			int random = (int)(Math.random()*45);
			if(arl.contains(random)) continue;
			arl.add(random);
			cnt++;
		}
		System.out.println(arl);
	}
}