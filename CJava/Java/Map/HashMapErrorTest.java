package Map;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapErrorTest {
	public static void main(String[] args){
		HashMap ht = new HashMap();
		ht.put(new A(60000), "Java teaching");
		ht.put(new A(87563),  "Java EE");
		Iterator it = ht.keySet().iterator();
		A first = (A)it.next();
		first.count = 87563;
		System.out.println(ht);
		ht.remove(new A(87563));
		System.out.println(ht);
		System.out.println(ht.get(new A(87563)));
	}
}
