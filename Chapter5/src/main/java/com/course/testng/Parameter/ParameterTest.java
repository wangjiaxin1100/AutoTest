package com.course.testng.Parameter;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class ParameterTest {
    @Test
    @Parameters({"name","age"})
    public void ParamTest1(String name,int age){
        System.out.println("");
        System.out.println("name=" + name);
        System.out.println("age="+age);
    }
}
