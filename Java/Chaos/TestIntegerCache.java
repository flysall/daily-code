
public class TestIntegerCache {
	public static void main(String[] args)
	{
		Integer in1 = new Integer(6);
		Integer in2 = Integer.valueOf(6);
		Integer in3 = Integer.valueOf(6);
		System.out.println(in1 == in2);
		System.out.println(in2 == in3);
	}
}
