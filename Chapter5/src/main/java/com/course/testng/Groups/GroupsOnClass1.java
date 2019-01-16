package com.course.testng.Groups;

import org.testng.annotations.Test;

@Test(groups = "Stu")
public class GroupsOnClass1 {
    public void Stu1(){
        System.out.println("GroupsOnClass1中的Stu1运行");
    }
    public void Stu2(){
        System.out.println("GroupsOnClass1中的Stu2运行");
    }
}
