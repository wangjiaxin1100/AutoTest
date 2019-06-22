package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MhttpClientForWJX {
    @Test
    public void test() throws IOException {
        //创建result存放返回结果
        String result;
        //get方法参数url
        HttpGet get = new HttpGet("https://www.baidu.com/");
        //client用来执行get方法
        HttpClient client = new DefaultHttpClient();
        //respons接执行get方法返回内容
        HttpResponse response = client.execute(get);
        //转换respon结果为utf-8格式
        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        输出访问结果
        System.out.println(result);
    }
}
