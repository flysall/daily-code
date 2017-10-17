package Generic;

public class GenericDiamondTest {
	public static void main(String[] args){
		MyClass<String> mc1 = new MyClass<>(5);
		MyClass<String> mc2 = new <Integer> MyClass<String>(5);
	}
}
