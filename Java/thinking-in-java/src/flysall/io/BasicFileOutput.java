package flysall.io;

import java.io.*;

public class BasicFileOutput {
    static String file = "/home/flysall/d/tmp/Java/BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.
                        read("/home/flysall/d/code/Java/ThinkingInJava/src/flysall/io/BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(file)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
