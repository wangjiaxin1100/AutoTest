package com.course.testng;

import org.testng.annotations.Test;

@Test(timeOut = 4000)
public class TimeOutTest {
    public void TestSuccess() throws InterruptedException{
        Thread.sleep(3000);
    }

@Test(timeOut = 2000)
    public void TestFailed() throws InterruptedException{
        Thread.sleep(3000);
    }
}
