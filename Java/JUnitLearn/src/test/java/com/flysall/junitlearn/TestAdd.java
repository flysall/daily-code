package com.flysall.junitlearn;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestAdd {
    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
        assertEquals("Not equal", str);
    }
}
