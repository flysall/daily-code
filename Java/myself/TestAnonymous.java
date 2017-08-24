package myself;

public class TestAnonymous {
	public void test(Product p) {
		System.out.println("buy a " + p.getName() + ", cost " + p.getPrice());
	}

	public static void main(String[] args) {
		TestAnonymous ta = new TestAnonymous();
		ta.test(new Product() {
			public double getPrice() {
				return 567.8;
			}

			public String getName() {
				return "AGP card";
			}
		});
	}
}
