package Map;

import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args){
		TreeMap tm = new TreeMap();
		tm.put(new R(3), "Java EE");
		tm.put(new R(-5), "Java teaching");
		tm.put(new R(9), "Android teaching");
		System.out.println(tm);
		System.out.println(tm.firstEntry());
		System.out.println(tm.lastKey());
		System.out.println(tm.higherKey(new R(2)));
		System.out.println(tm.subMap(new R(-1), new R(4)));
	}
}
