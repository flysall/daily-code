package flysall.io;

import java.io.*;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("/home/flysall/d/code/Java/ThinkingInJava/out/production/ThinkingInJava/flysall/io/DirectoryDemo.class"));
        int c;
        long start = System.currentTimeMillis();
        while((c = in.read()) != -1)
            System.out.print(c);
        long end = System.currentTimeMillis();
        System.out.println(" \nLast time: " + (end - start) + "ms");
    }
}
