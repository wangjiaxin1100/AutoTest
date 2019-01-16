package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    //异常测试使用场景，期望结果为某个异常时，
    //比如传入不合法参数，程序抛出异常
    //预期结果满足我们的要求
    //这是一个测试结果会失败的测试
    @Test(expectedExceptions = RuntimeException.class)
    public void RunTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    //这是一个成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void RunTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }
}
