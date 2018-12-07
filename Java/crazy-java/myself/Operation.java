package myself;

public enum Operation {
	PLUS, MINUS, TIMES, DIVIDE;
	double eval(double x, double y){
		switch(this){
		case PLUS: return x + y;
		case MINUS: return x - y;
		case TIMES: return x*y;
		case DIVIDE: return (int)(x / y);
		default: return 0;
		}
	}
	public static void main(String[] args)
	{
		System.out.println(Operation.PLUS.eval(3, 4));
		System.out.println(Operation.MINUS.eval(5, 4));
		System.out.println(Operation.TIMES.eval(5, 4));
		System.out.println(Operation.DIVIDE.eval(5,4));
	}
}
