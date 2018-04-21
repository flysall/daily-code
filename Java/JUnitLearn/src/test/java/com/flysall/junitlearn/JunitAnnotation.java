package com.flysall.junitlearn;

import static com.flysall.util.Print.*;
import org.junit.*;

public class JunitAnnotation {
    @BeforeClass
    public static void beforeClass() {
        println("in before class");
    }

    @AfterClass
    public static void afterClass() {
        println("in after class");
    }

    @Before
    public void before() {
        println("in before");
    }

    @After
    public void after() {
        println("in after");
    }

    @Test
    public void test() {
        println("in test");
    }

    @Ignore
    public void ignoreTest() {
        println("in ignore test");
    }
}
