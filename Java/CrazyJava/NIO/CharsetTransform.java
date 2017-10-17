package NIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {
	public static void main(String[] args) throws Exception
	{
		Charset cn = Charset.forName("GBK");
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		CharBuffer cbuff = CharBuffer.allocate(8);
		cbuff.put('Ыя');
		cbuff.put('Юђ');
		cbuff.put('Пе');
		cbuff.flip();
		ByteBuffer bbuff = cnEncoder.encode(cbuff);
		for(int i = 0; i < bbuff.capacity(); i++){
			System.out.println(bbuff.get(i) + " ");
		}
		System.out.println("\n" + cnDecoder.decode(bbuff));
	}
}
