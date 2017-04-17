package collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args){
	List books = new ArrayList();
	books.add(new String("Java EE"));
	books.add(new String("Java teaching"));
	books.add(new String("Android teaching"));
	System.out.println(books);
	books.add(1, new String("Ajax teaching"));
	for(int i = 0; i < books.size(); i++){
		System.out.println(books.get(i));
	}
	books.remove(2);
	System.out.println(books);
	System.out.println(books.indexOf(new String("Ajax teaching")));
	books.set(1, new String("Java teaching"));
	System.out.println(books);
	System.out.println(books.subList(1, 2));
	System.exit(0);
	}
}
