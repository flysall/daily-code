package com.flysall.junitlearn;

import org.junit.runner.*;
import org.junit.runner.notification.*;

import static com.flysall.util.Print.println;

public class RunnerForJunitAnnotation {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitAnnotation.class);
        for(Failure failure : result.getFailures())
            println(failure);
        println("runtime is: " + result.getRunTime() + "ms. result is " + result.wasSuccessful());
    }
}
