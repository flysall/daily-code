package collection;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args){
		HashSet books = new HashSet();
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		System.out.println(books);
	}
}
