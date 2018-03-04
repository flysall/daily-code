package flysall.io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetCannel {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("/home/flysall/d/tmp/Java/data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        // Add to the end of the file:
        fc = new RandomAccessFile("/home/flysall/d/tmp/Java/data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        // Read the file:
        fc = new FileInputStream("/home/flysall/d/tmp/Java/data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining())
            System.out.print((char)buff.get());
    }
}
