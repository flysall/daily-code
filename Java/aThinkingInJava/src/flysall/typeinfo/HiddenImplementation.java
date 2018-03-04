package flysall.typeinfo;

import flysall.typeinfo.interfacea.*;
import flysall.typeinfo.packageaccess.*;
import java.lang.reflect.*;

public class HiddenImplementation {
    static void callHiddenMethod(Object a, String methodName)
        throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C':
         /* if(a instanceof C) {
          C c = (C)a;
          c.g();
        } */
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }
}
