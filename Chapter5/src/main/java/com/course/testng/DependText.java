package com.course.testng;

import org.testng.annotations.Test;

public class DependText {
    @Test
    public void Test1(){
        System.out.println("text1执行");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods ={"Test1"})
    public void Test2(){
        System.out.println("text2执行");
    }
}
