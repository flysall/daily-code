package flysall.io;

import java.io.*;

public class FreeZeAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(new
            FileOutputStream("/home/flysall/d/tmp/Java/X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}
