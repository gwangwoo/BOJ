
public class make_testcase {

	public static void main(String[] args) {
		for(int a = 0 ; a < 10 ; a++) {
			boolean visited[] = new boolean[10];
			System.out.println(3);
			for(int i = 0 ; i < 3 ; i++) {
				int j = 0;
				while(true) {
					if(j == 3) break;
					int val = (int)(Math.random()*10 % 11);
					if(visited[val] || val == 0) continue;
					visited[val] = true;
					System.out.print(val + " ");
					j++;
				}
				System.out.println();
			}
			System.out.println();

		}
	}

}
