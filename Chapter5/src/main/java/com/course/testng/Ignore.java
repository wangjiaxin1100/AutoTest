package com.course.testng;

import org.testng.annotations.Test;

public class Ignore {
    @Test
    public void IgnoreTest1(){
        System.out.println("Ignore执行1");
    }
    @Test(enabled = true)
    public void IgnoreTest2(){
        System.out.println("Ignore执行2");
    }
    @Test(enabled = false)
    public void IgnoreTest3(){
        System.out.println("Ignore执行3");
    }
}
