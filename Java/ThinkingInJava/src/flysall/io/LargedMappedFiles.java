package flysall.io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

import static net.mindview.util.Print.*;

public class LargedMappedFiles {
    static int length = 0x8FFFFFF; // 128M

    public static void main(String[] args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile("/home/flysall/d/tmp/Java/test.dat", "rw").getChannel().
                map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++)
            out.put((byte) 'x');
        print("Finished writing");
        for(int i = length/2; i < length/2 + 6; i++)
            printnb((char)out.get(i));
    }
}