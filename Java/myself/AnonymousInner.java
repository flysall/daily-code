package myself;

public class AnonymousInner {
	public void test(Device d) {
		System.out.println("buy a " + d.getName() + " cost " + d.getPrice());
	}

	public static void main(String[] args) {
		AnonymousInner ai = new AnonymousInner();
		ai.test(new Device("apple") {
			public double getPrice() {
				return 67.8;
			}
		});
		Device d = new Device() {
			{
				System.out.println("the initiate block of anonymous class...");
			}

			public double getPrice() {
				return 56.2;
			}

			public String getName() {
				return "Keyboard";
			}
		};
		ai.test(d);
	}
}
