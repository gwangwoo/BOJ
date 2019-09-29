
public class Main2 {

	public static void main(String[] args) {

		Product p = new Product();
		TV t = new TV();
		System.out.println(p.toString());
		System.out.println(t.toString());
		Product pp = new TV();
		System.out.println(pp.name);
		System.out.println(pp.toString());
//		TV tt = (TV)new Product();
		TV ppp = (TV)pp;
		System.out.println(ppp.toString());
		System.out.println(ppp.inch);
		double a;
		a = 3%5+2;
		System.out.println(a);
	}

}


class TV extends Product {
	int inch = 10;
	TV(){
		super();
	}
	public String toString() {
		return "자식 클래스";
	}
}

class Product {
	String name,type;
	int price;
	Product(){};
	public String toString() {
		return "부모 클래스";
	}
}
