package com.course.testng.Parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Test(dataProvider = "data")
public class DataProviderTest {
    public void TestDataProviderTest(String name, int age) {
        System.out.println("name=" + name + "age" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] O = new Object[][]{
                {"zhangsan", 10},
                {"lisi", 20},
                {"wangwu", 30},
        };
        return O;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name, int age){
        System.out.println("test1方法name"+name+";age="+age);

    }
    @Test(dataProvider = "methodData")
    public void test2(String name, int age){
        System.out.println("test2方法name"+name+";age="+age);
    }

    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test1")) {
            result = new Object[][]{
                    {"zhangsan", 20},
                    {"lisi", 30},
            };
        } else if (method.getName().equals("test2")) {
            result = new Object[][]{
                    {"wangwu", 50},
                    {"zhaoliu", 60},
            };
        }
        return result;}
    }