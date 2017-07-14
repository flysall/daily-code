
public class TestFinalVariable {
	final int a = 6;
	final String str;
	final int c;
	final static double d;
	//final char ch;
	
	{
		str = "hello";
		//a = 9;
	}
	static
	{
		d = 5.6;
	}
	
	public TestFinalVariable()
	{
		c = 5;
	}
	public static void main(String[] args)
	{
		TestFinalVariable tf = new TestFinalVariable();
		System.out.println(tf.a);
		System.out.println(tf.c);
		System.out.println(tf.d);
	}
}










