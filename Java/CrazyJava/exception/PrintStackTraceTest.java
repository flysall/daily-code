package exception;

public class PrintStackTraceTest {
	public static void main(String[] args){
		firstMethod();
	}
	public static void firstMethod(){
		secondMethod();
	}
	public static void secondMethod(){
		thirdMethod();
	}
	public static void thirdMethod(){
		throw new SelfException("�Զ����쳣��Ϣ");
	}
}