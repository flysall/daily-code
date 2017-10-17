package exception;

public class DivTest {
	public static void main(String[] args){
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("the result of div is: " + c);
		}
		catch(IndexOutOfBoundsException ie){
			System.out.println("the array cross the border, the parameter isn't enough");
		}
		catch(NumberFormatException ne){
			System.out.println("the format of number is abnormal, program only can accept integer parameter");
		}
		catch(ArithmeticException ae){
			System.out.println("Arithmetic error");
		}
		catch(Exception e){
			System.out.println("unknown exception");
		}
	}
}
