package collection;

import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {
	public static void main(String[] args){
		Collection books = new HashSet();
		books.add("Java EE");
		books.add("Java teaching");
		books.add("Android");
		for(Object obj : books){
			String book = (String)obj;
			System.out.println(book);
		}
		System.out.println(books);
	}
}
