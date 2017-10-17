package Queue;

import java.util.ArrayDeque;
//import java.util.ArrayDeque;

public class ArrayDequeQueue {
	public static void main(String[] args){
		ArrayDeque queue = new ArrayDeque();
		queue.offer("Java teaching");
		queue.offer("Java EE");
		queue.offer("Android teaching");
		System.out.println(queue);
		System.out.println("After peeking, " + queue.peek());
		System.out.println(queue);
		System.out.println("After polling, " + queue.poll());
		System.out.println(queue);
	}
}
