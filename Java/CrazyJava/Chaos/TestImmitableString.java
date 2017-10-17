
public class TestImmitableString {
	public static void main(String[] args)
	{
		String str1 = new String("hello");
		String str2 = new String("hello");
		System.out.println(str1.hashCode());
	}
}
