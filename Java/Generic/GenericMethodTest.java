package Generic;

import java.util.ArrayList;
import java.util.Collection;


public class GenericMethodTest {
	static <T> void fromArrayToCollection(T[] a, Collection<T> c)
	{
		for(T o : a){
			c.add(o);
		}
	}
	public static void main(String[] args){
		Object oa = new Object[100];
		Collection<Object> co = new ArrayList();
		//fromArrayToCollection(oa,co);
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<>();
		fromArrayToCollection(sa,co);
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList<>();
		fromArrayToCollection(ia,cn);
		fromArrayToCollection(fa,cn);
		fromArrayToCollection(na,cn);
		fromArrayToCollection(na,co);
	}
}






