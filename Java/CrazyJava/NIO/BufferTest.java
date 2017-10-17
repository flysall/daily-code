package NIO;

import java.nio.CharBuffer;

public class BufferTest {
	public static void main(String[] args){
		CharBuffer buffer = CharBuffer.allocate(8);
		System.out.println("capacity: " + buffer.capacity());
		System.out.println("limit: " + buffer.limit());
		System.out.println("position: " + buffer.position());
		buffer.put('a');
		buffer.put('b');
		buffer.put('c');
		System.out.println("After three elements, position is: " + buffer.position());
		buffer.flip();
		System.out.println("Executing flip(), limit = " + buffer.limit());
		System.out.println("position: " + buffer.position());
		System.out.println("the first element(position = 0): " + buffer.get());
		System.out.println("removing the first element, position = " + buffer.position());
		buffer.clear();
		System.out.println("Executing clear(), limit = " + buffer.limit());
		System.out.println("Executing clear(), position = " + buffer.position());
		System.out.println("Executing clear(), the contents of buffer area is still here: " + "the third element is: " + buffer.get(2));
		System.out.println("Excuting absolute read, position = " + buffer.position());
	}
}
