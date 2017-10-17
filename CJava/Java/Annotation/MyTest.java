package Annotation;

public class MyTest {
	@Testable
	public static void m1()
	{
	}
	public static void m2()
	{
	}
	@Testable
	public static void m3(){
		throw new IllegalArgumentException("the parameter is error");
	}
	public static void m4(){}
	@Testable
	public static void m5(){}
	public static void m6(){}
	@Testable
	public static void m7(){
		throw new RuntimeException("the program is exception");
	}
	public static void m8(){}
}
