package exception;

public class ThrowTest {
	public static void main(String[] args){
		try{
			throwChecked(-3);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		throwRuntime(3);
	}
	public static void throwChecked(int a) throws Exception{
		if(a>0){
			throw new RuntimeException("the value of a is bigger than 0, error");
		}
	}
	public static void throwRuntime(int a){
		throw new RuntimeException("the value of a is bigger than 0, error");
	}
}
