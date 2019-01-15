package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    //最基本注解，标识测试方法，把方法标记为测试的一部分
    @Test
    public void  TestCase1(){
        System.out.println("这是测试用例1");
    }
    @Test
    public void  TestCase2(){
        System.out.println("这是测试用例2");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BefreMethod这是在测试方法之前运行的");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod这是在测试方法之后运行的");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass这是在类运行之前运行的方法");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass这是在类运行之后运行的方法");
    }
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite测试套件");
    }
}
