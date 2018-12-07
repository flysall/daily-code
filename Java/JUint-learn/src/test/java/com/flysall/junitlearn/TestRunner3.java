package com.flysall.junitlearn;

import static com.flysall.util.Print.*;

import org.junit.runner.*;
import org.junit.runner.notification.*;

public class TestRunner3 {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJunit3.class);
        for(Failure failure : result.getFailures())
            println(failure);
        println(result.wasSuccessful());
    }
}
