package flysall.io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.nio.charset.*;

public class BufferToText {
    private static final int BSIZE = 1024;
    private static final String file = "/home/flysall/d/tmp/Java/data2.txt";
    public static void main(String[] arg) throws Exception {
        FileChannel fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new FileInputStream(file).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();

        // Doesn't work:
        System.out.println(buff.asCharBuffer());
        // Decode using this system's default charse:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decode using " + encoding + ": " +
            Charset.forName(encoding).decode(buff));
        // Or encode with something that will print:
        fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();
        // Now try reading again:
        fc = new FileInputStream(file).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        // Use a CharBuffer to write through:
        fc = new FileOutputStream(file).getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
        // Read and display:
        fc = new FileInputStream(file).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
