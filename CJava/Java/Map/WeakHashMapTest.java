package Map;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args){
		WeakHashMap whm = new WeakHashMap();
		whm.put(new String("chinese"), new String("good"));
		whm.put(new String("math"), new String("nice"));
		whm.put(new String("english"),  new String("mid"));
		whm.put("java", new String("mid"));
		System.out.println(whm);
		System.gc();
		System.runFinalization();
		System.out.println(whm);
	}
}
