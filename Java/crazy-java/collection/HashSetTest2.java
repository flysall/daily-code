package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest2 {
	public static void main(String[] args){
		HashSet hs = new HashSet();
		hs.add(new R(5));
		hs.add(new R(-3));
		hs.add(new R(9));
		hs.add(new R(-2));
		System.out.println(hs);;
		Iterator it = hs.iterator();
		R first = (R)it.next();
		first.count = -3;
		System.out.println(hs);
		hs.remove(new R(-3));
		System.out.println(hs);
		System.out.println("hs是否包含count为-3的R对象? "
				+ hs.contains(new R(-3)));
		System.out.println("hs是否包含count为-2的R对象? "
				+ hs.contains(new R(-2)));
	}
}









