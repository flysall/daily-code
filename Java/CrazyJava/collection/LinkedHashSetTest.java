package collection;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args)
	{
	LinkedHashSet books = new LinkedHashSet();
	books.add("Java teaching");
	books.add("Java EE");
	System.out.println(books);
	books.remove("Java teaching");
	books.add("Java teaching");
	System.out.println(books);
	}
}
