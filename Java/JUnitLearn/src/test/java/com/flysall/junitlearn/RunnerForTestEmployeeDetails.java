package com.flysall.junitlearn;

import static com.flysall.util.Print.*;
import org.junit.runner.*;
import org.junit.runner.notification.*;

public class RunnerForTestEmployeeDetails {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestEmployeeDetails.class);
        for(Failure failure : result.getFailures())
            println(failure);
        println(result.wasSuccessful());
    }
}
