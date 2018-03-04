package flysall.io;

import java.nio.channels.*;
import java.util.concurrent.*;
import java.io.*;

public class FileLocking {
    private static final String file = "/home/flysall/d/tmp/Java/file.txt";
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(file);
        FileLock fl = fos.getChannel().tryLock();
        if(fl != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(5000);
            fl.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
