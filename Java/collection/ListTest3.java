package collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest3 {
	public static void main(String[] args){
		List books = new ArrayList();
		books.add(new String("Java EE"));
		books.add(new String("Java teaching"));
		books.add(new String("Android teaching"));
		books.add(new String("iOS teaching"));
		books.sort((o1, o2)->(((String)o1).length() - ((String)o2).length()));
		System.out.println(books);
		books.replaceAll(ele->((String)ele).length());
		System.out.println(books);
	}
}
