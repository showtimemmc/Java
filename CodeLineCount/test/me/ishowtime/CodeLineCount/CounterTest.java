package me.ishowtime.CodeLineCount;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void testCountFile() throws Exception {
        String filePath = "testData";
        int result = Counter.countFile(new File(filePath));
        assertEquals(10,result);
    }
}