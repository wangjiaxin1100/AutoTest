package com.course.httpclient.demo;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        //存放结果
        String result;
        SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
        HttpGet  get = new HttpGet("https://news.sina.com.cn/");
        //用来执行get方法
        HttpClient client = new DefaultHttpClient();
        HttpResponse response =client.execute(get);
        //转换respon结果为utf-8格式
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}