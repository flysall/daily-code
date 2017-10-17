package exception;

public class SelfException extends RuntimeException{
	SelfException(){}
	SelfException(String msg){
		super(msg);
	}
}
