
public class lambda_expression {

	@FunctionalInterface
	interface Calc {
		public int min(int x,int y);
	}

	public static void main(String[] args) {
		Calc minNum = Math::min;
		System.out.println(minNum.min(3, 4));
		new Thread(new Runnable() {
			public void run() {
				System.out.println("전통적인 방식의 일회용 스레드 생성");
			}
		}).start();

		new Thread(()->{
			System.out.println("람다 표현식을 사용한 일회용 스레드 생성");
		}).start();
	}
}
