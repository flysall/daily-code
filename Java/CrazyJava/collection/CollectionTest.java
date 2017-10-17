package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
	public static void main(String[] args){
		Collection c = new ArrayList();
		c.add("Monkey");
		c.add(6);
		System.out.println("the element amount of collection is: " + c.size());
		c.remove(6);
		System.out.println("After removing, the element amount of collection is: " + c.size());
		System.out.println("Does the c collection contain the String \"Monkey\"? " + c.contains("Monkey"));
		c.add("Java EE");
		System.out.println("Ater adding, the elements of c collection is: " + c);
		Collection books = new HashSet();
		books.add("Java EE");
		books.add("Java teaching");;
		System.out.println("Does c colllection contain books collection completely? " + c.containsAll(books));
		c.removeAll(books);
		System.out.println("After removeAlling, the elements of c collection is: " + c);
		c.clear();
		System.out.println("After clearing, the elements of c collection is: " + c);
		books.retainAll(c);
		System.out.println("After retainAlling, the elements of books collection is: " + books);
	}
}
















