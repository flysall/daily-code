package flysall.io;

import java.io.*;

import static net.mindview.util.Print.*;

class Blip1 implements Externalizable {
    public Blip1() {
        print("Blip1 Constructor");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip1.writeExternal");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        print("Blip2 Constructor");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip2.writeExternal");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip2.readExternal");
    }
}

public class Blips {
    static final String BLIPS = "/home/flysall/d/tmp/Java/Blips.out";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new
                FileOutputStream(BLIPS));
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        // Get them back:
        ObjectInputStream in = new ObjectInputStream(new
                FileInputStream(BLIPS));
        print("Recovering b1:");
        b1 = (Blip1)in.readObject();
        b2 = (Blip2)in.readObject();
    }
}
