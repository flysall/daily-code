
public class TestEqual {
	public static void main(String[] args)
	{
		int it = 65;
		float fl = 65.0f;
		System.out.println("Is 65 equal to 65.0f? " + (it == fl));
		char ch = 'A';
		System.out.println("Is 65 equal to A? " + (it == ch));
		String str1 = new String("hello");
		String str2 = new String ("hello");
		System.out.println("Is str1 equal to str2? " + (str1 == str2));
		System.out.println("Is str1 equal to str2? " + (str1.equals(str2)));
	}
}
