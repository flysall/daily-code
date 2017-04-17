package collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest2 {
	public static void main(String[] args){
		List books = new ArrayList();
		books.add(new String("Java EE"));
		books.add(new String("Java teaching"));
		books.add(new String("Android teaching"));
		System.out.println(books);
		books.remove(new AA());
		System.out.println(books);
		books.remove(new AA());
		System.out.println(books);
	}
}
