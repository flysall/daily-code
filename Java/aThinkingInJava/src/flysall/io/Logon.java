package flysall.io;

import java.util.concurrent.*;
import java.io.*;
import java.util.*;
import static net.mindview.util.Print.*;

public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;
    static final String LOGON = "/home/flysall/d/tmp/Java/Logon.out";
    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }
    public String toString() {
        return "logon info: \n  username: " + username +
                "\n  date: " + date + "\n  password: " + password;
    }

    public static void main(String[] args) throws Exception {
        Logon a = new Logon("Hulk", "myLittlePony");
        print("loggon a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new
            FileOutputStream(LOGON));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1);  // Delay
        // Get back:
        ObjectInputStream in = new ObjectInputStream(new
            FileInputStream(LOGON));
        print("Recovering object at " + new Date());
        a = (Logon)in.readObject();
        print("Logon a = " + a);
    }
}
