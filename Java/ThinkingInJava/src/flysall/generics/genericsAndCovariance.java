package flysall.generics;

import java.util.*;

public class genericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // can't add any type of object:
//        flist.add(new Apple());
        flist.add(null);
        Fruit f = flist.get(0);
        System.out.println(f);
    }
}
