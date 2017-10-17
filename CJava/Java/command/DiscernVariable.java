package command;

public class DiscernVariable {
	private String prop = "extend attribute";

	private class InClass {
		private String prop = "innner attribute";

		public void info()
		
		{
			String prop = "local variable";
			System.out.println("extend attribute value is: " + DiscernVariable.this.prop);
			System.out.println("inner attrubute value is: " + this.prop);
			System.out.println("local variable value is: " + prop);
		}
	}

	public void test() {
		InClass in = new InClass();
		in.info();
	}

	public static void main(String[] args) {
		new DiscernVariable().test();
	}
}
