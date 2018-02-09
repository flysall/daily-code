package flysall.annotations;

import net.mindview.atunit.*;
import net.mindview.util.*;

public class AtUnitExample1 {
    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }

    @Test boolean m2() {
        return methodTwo() == 2;
    }

    @Test private boolean m3() {
        return true;
    }

    // Show output for failure:
    @Test boolean failureTest() {
        return false;
    }

    @Test boolean anotherdisappointment() {
        return false;
    }

    public static void main(String[] args) throws Exception  {
        OSExecute.command("java flysall/annotations/AtUnitExample1");
    }
}
