package exception;

public class MutilExceptionTest {
	public static void main(String[] args){
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("the result of divide is: " + c);
		}
		catch(IndexOutOfBoundsException |  NumberFormatException | ArithmeticException ie){
			System.out.println("the program cross the border or the format of number is abnormal or Arithmetic exception");
		}
		catch (Exception e){
			System.out.println("unknown exception");
		}
	}
}
