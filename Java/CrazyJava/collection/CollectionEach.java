package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionEach {
	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("Java EE");
		books.add("Java teaching");
		books.add("Android");
		Iterator it = books.iterator();
		it.forEachRemaining(obj -> System.out.println("迭代元素集合: " + obj));
	}
}








