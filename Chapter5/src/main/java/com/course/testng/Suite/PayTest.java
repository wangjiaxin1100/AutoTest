package com.course.testng.Suite;

import org.testng.annotations.Test;

public class PayTest {
    @Test(enabled = true)
    public void PaySuccess(){
        System.out.println("支付宝支付成功了");
    }
}
