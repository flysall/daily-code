package com.flysall.junitlearn;

import static com.flysall.util.Print.*;
import junit.framework.*;

public class JunitTestSuite {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite(TestJunit1.class, TestJunit2.class, TestJunit3.class);
        TestResult result = new TestResult();
        suite.run(result);
        println("Number of test cases = " + result.runCount());
    }
}
