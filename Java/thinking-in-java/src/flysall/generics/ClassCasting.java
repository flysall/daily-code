package flysall.generics;

import java.util.*;
import java.io.*;

public class ClassCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new
            FileInputStream(args[0]));
        List<Widget> lw2 = List.class.cast(in.readObject());
    }
}
