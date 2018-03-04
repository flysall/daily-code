package flysall.io;

import java.io.*;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new
                        FileInputStream("/home/flysall/d/code/Java/ThinkingInJava/src/flysall/io/TestEOF.java")));
        while(in.available() != 0)
            System.out.print((char)in.readByte());
        // 如果有中文(char)in.readByte() gg!
    }
}
