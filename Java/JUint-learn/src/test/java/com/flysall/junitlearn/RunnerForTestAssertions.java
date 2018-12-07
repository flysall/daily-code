package com.flysall.junitlearn;

import static com.flysall.util.Print.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.*;

public class RunnerForTestAssertions {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestAssertions.class);
        for(Failure failure : result.getFailures())
            println(failure);
        println(result.wasSuccessful());
    }
}
