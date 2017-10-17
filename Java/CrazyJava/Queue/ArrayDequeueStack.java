package Queue;

import java.util.ArrayDeque;

public class ArrayDequeueStack {
	public static void main(String[] args){
		ArrayDeque stack = new ArrayDeque();
		stack.push("Java teaching");
		stack.push("java EE");
		stack.push("Android teaching");
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
