package com.flysall.junitlearn;

import static com.flysall.util.Print.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TestJunit2 extends TestCase {
    protected double fValue1;
    protected double fValue2;

    @Before
    public void setUp() {
        fValue1 = 2.0;
        fValue2 = 3.0;
    }

    @Test
    public void testAdd() {
        println("No of Test Case = " + this.countTestCases());

        String name = this.getName();
        println("Test Case Name = " + name);

        // test setName
        this.setName("testNewAdd");
        String newName = this.getName();
        println("Updated Test Case Name = " + newName);
    }

    // tearDown is used to close the connection up clean up activities
    public void tearDown() {

    }
}
