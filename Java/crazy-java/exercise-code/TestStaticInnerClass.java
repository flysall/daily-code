

public class TestStaticInnerClass {
	private int prop1 = 9;
	private static int prop2 = 9;
	static class StaticInnerClass
	{
		private static int age;
		public void accessOuterProp()
		
		{
			System.out.println(prop2);
		}
	}
}

