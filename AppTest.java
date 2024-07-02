// src/test/java/com/example/AppTest.java
package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void testGetGreeting() {
        assertEquals("Hello, W", App.getGreeting());
    }
}
