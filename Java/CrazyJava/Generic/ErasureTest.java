package Generic;

public class ErasureTest {
	public static void main(String[] args){
		Aple<Integer> a = new Aple<>(6);
		Integer as = a.getSize();
		Aple b = a;
		Number size1 = b.getSize();
	}
}
