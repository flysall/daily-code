package flysall.io;

import java.io.*;
import static net.mindview.util.Print.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new
            BufferedOutputStream(new FileOutputStream("/home/flysall/d/tmp/Java/Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new
                FileInputStream("/home/flysall/d/tmp/Java/Data.txt")));
        print(in.readDouble());
        print(in.readUTF());
        print(in.readDouble());
        print(in.readUTF());
    }
}
