package Queue;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args){
		LinkedList books = new LinkedList();
		books.offer("java teaching");
		books.push("Java EE");
		books.offerFirst("Android teaching");
		for (int i = 0; i < books.size(); i++){
			System.out.println("traversaling, " + books.get(i));
		}
		System.out.println(books.peekFirst());
		System.out.println(books.peekLast());
		System.out.println("Poping, " + books.pop());
		System.out.println("After poping, " + books);
		System.out.println("Polling, " + books.pollLast());
		System.out.println("After polling, " + books);
	}
}
