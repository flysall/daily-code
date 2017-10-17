package command;

public class Outer {
	private int outProp = 9;

	public class Inner {
		private int inProp = 5;

		public void acessOutterProp() {
			System.out.println("outter class's outProp attribute value is: " + outProp);
		}
	}

	public void accessInnerProp() {
		System.out.println("inner class's inProp attribute value is: " + new Inner().inProp);
	}
	public static void main(String[] args)
	{
		Outer out = new Outer();;
		out.accessInnerProp();
	}
}
