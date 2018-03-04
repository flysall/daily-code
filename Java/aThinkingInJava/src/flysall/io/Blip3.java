package flysall.io;

import java.io.*;
import static net.mindview.util.Print.*;

public class Blip3 implements Externalizable {
    private int i;
    private String s;   // No initialized
    static final String BLIP = "/home/flysall/d/tmp/Java/Blip3.out";
    public Blip3() {
        print("Blip3 Constructor");
        // s, i not initialized
    }
    public Blip3(String x, int a) {
        print("Blip3(String x, int a)");
        s = x;
        i = a;
    }

    public String toString() {
        return s + i;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip3.writeExternal");
        // You must do this:
        out.writeObject(s);
        out.writeInt(i);
    }

    public void readExternal(ObjectInput  in) throws IOException, ClassNotFoundException {
        print("Blip3.readExternal");
        // You must do this:
        s = (String)in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip3 b3 = new Blip3("A String ", 47);
        print(b3);
        ObjectOutputStream o = new ObjectOutputStream(new
            FileOutputStream(BLIP));
        print("Saving object:");
        o.writeObject(b3);
        o.close();
        // Get it back:
        ObjectInputStream in = new ObjectInputStream(new
            FileInputStream(BLIP));
        print("Recovering b3:");
        b3 = (Blip3)in.readObject();
        print(b3);
    }
}
