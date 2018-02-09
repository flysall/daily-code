package flysall.annotations;

import java.io.*;
import net.mindview.atunit.*;
import net.mindview.util.*;

public class AtUnitExample2 {
    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test void assertExample() {
        assert methodOne().equals("This is methodOne");
    }

    @Test void asseertFailureExample() {
        assert 1 == 2 : "What a surprise!";
    }

    @Test void exceptionExample() throws IOException {
        new FileInputStream("nofile.txt");  // Throws
    }

    @Test boolean assertAndReturn() {
        assert methodTwo() == 2: "methodTwo must equal 2";
        return methodOne().equals("This is methodOne");
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command(
                "java");
    }
}
