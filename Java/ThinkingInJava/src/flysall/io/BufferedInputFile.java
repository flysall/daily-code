package flysall.io;

import java.io.*;

public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        // Reading by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("/home/flysall/d/code/Java/ThinkingInJava/src/flysall/io/BufferedInputFile.java"));
    }
}
