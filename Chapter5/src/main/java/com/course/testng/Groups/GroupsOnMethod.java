package com.course.testng.Groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void Test1(){
        System.out.println("这是服务端的组测试方法1");
    }
    @Test(groups = "server")
    public void Test2(){
        System.out.println("这是服务端的组测试方法2");
    }
    @Test(groups = "client")
    public void Test3(){
        System.out.println("这是客户端的组测试方法1");
    }
    @Test(groups = "client")
    public void Test4(){
        System.out.println("这是客户端的组测试方法2");
    }
    @BeforeGroups("server")
    public void BeforeGroupOnServer(){
        System.out.println("这是服务端组运行前的运行方法");
    }
    @AfterGroups("server")
    public void AfterGroupOnServer(){
        System.out.println("这是服务端组运行后的运行方法");
    }
    @BeforeGroups("client")
    public void BeforeGroupOnClient(){
        System.out.println("这是服务端组运行前的运行方法");
    }
    @AfterGroups("client")
    public void AfterGroupOnClient(){
        System.out.println("这是服务端组运行后的运行方法");
    }
}
