package scanner;

public class IdentituHashCodeTest {
	public static void main(String[] args)
	{
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1.hashCode() + "----" + s2.hashCode());
		System.out.println(System.identityHashCode(s1) + "----" + System.identityHashCode(s2));
	}
}
