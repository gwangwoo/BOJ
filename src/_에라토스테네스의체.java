
public class _에라토스테네스의체 {

	public static void main(String[] args) {
		boolean prime[] = new boolean[10000];
		prime[0] = prime[1] = true;
		for(int i = 2 ; i * i < 10000 ; i++) {
			if(!prime[i]) {
				for(int j = i * i ; j < 10000 ; j+=i) {
					prime[j] = true;
				}
			}
		}
		for(int i = 0 ; i < 10000 ; i++) {
			if(!prime[i]) System.out.print(i + " ");
		}
	}

}
