package flysall.io;

import java.io.*;

public class FileOutPutShortcut {
    static String file = "/home/flysall/d/tmp/Java/FileOutputShortcut.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read("/home/flysall/d/code/Java/ThinkingInJava/src/flysall/io/FileOutPutShortcut.java")));
        // Here is the shortcut:
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
