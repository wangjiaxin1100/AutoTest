package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void Test1(){
        System.out.println("test1执行");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods ={"Test1"})
    public void Test2(){
        System.out.println("test2执行");
    }
}
