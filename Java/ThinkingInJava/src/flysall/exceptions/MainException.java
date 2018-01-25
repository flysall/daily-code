package flysall.exceptions;

import java.io.*;

public class MainException {
    public static void main(String[] args) throws Exception {
        // Open the file:
        FileInputStream file = new FileInputStream("/home/flysall/d/code/Java/ThinkingInJava/src/flysall/exceptions/MainException.java");
        file.close();
    }
}
