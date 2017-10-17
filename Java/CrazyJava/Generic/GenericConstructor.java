package Generic;

public class GenericConstructor {
	public static void main(String[] args){
		new Foo("Java teaching");
		new Foo(200);
		new <String> Foo("Android teaching");
		//new <String> Foo(12.3);
	}
}
