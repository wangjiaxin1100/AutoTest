package com.course.testng.Groups;

import org.testng.annotations.Test;

@Test(groups = "Stu")
public class GroupsOnClass2 {
    public void Stu1(){
        System.out.println("GroupsOnClass2中的Stu1运行");
    }
    public void Stu2(){
        System.out.println("GroupsOnClass2中的Stu2运行");
    }
}
