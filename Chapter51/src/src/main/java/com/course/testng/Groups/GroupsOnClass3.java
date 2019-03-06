package com.course.testng.Groups;

import org.testng.annotations.Test;

@Test(groups = "Teach")
public class GroupsOnClass3 {
    public void Teach1(){
        System.out.println("GroupsOnClass3中的Teach1运行");
    }
    public void Teach2(){
        System.out.println("GroupsOnClass3中的Teach2运行");
    }
}
