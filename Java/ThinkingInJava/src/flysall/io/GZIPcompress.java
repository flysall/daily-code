package flysall.io;

import java.util.zip.*;
import java.io.*;

public class GZIPcompress {
    static String testGZ = "/home/flysall/d/tmp/Java/test.gz";
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println(
                    "Usage: \nGZIPcompress file\n" +
                            "\tUses GZIP compression to compress " +
                            "the file to test.gz");
            System.exit(1);
        }
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new
            GZIPOutputStream(new FileOutputStream(testGZ)));
        System.out.println("Writing file");
        int c;
        while((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new
            GZIPInputStream(new FileInputStream(testGZ))));
        String s;
        while((s = in2.readLine()) != null)
            System.out.println(s);
    }
}
