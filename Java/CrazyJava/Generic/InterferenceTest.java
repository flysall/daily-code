package Generic;

public class InterferenceTest {
	public static void main(){
		MyUtil<String> ls = MyUtil.nil();
		MyUtil<String> mu = MyUtil.<String>nil();
		MyUtil.cons(42, MyUtil.nil());
	}
}
