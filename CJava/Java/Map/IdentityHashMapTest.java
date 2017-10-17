package Map;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
	public static void main(String[] args) {
		IdentityHashMap ihm = new IdentityHashMap();
		ihm.put(new String("chinese"), 89);
		ihm.put(new String("chinese"), 78);
		ihm.put("java", 93);
		ihm.put("java", 98);
		System.out.println(ihm);
	}
}
