package flysall.typeinfo;

import java.lang.reflect.*;
import static net.mindview.util.Print.*;

class WithPrivateFinalField {
    private int i = 1;
    private final String s = "I'm totally safe";
    private String s2 = "Am I safe?";
    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}

public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        print(pf);
        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        print("f.getInt(pf): " + f.getInt(pf));
        f.setInt(pf, 47);
        print(pf);
        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        print("f.get(pf): " + f.get(pf));
        f.set(pf, "No, you're not!");
        print(pf);
        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        print("f.get(pf): " + f.get(pf));
        f.set(pf, "No, you'are not!");
        print(pf);
    }
}
