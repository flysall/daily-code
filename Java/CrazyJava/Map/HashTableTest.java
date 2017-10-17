package Map;

import java.util.Hashtable;

public class HashTableTest {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put(new A(60000), "Java teaching");
		ht.put(new A(87563), "Java EE");
		ht.put(new A(1232), new B());
		System.out.println(ht);
		System.out.println(ht.containsValue("test keychar"));

		System.out.println(ht.containsValue(new A(87563)));
		ht.remove(new A(1232));
		System.out.println(ht);
	}
}
