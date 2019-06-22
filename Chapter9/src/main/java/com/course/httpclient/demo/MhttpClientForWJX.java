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
        //����result��ŷ��ؽ��
        String result;
        //get��������url
        HttpGet get = new HttpGet("https://www.baidu.com/");
        //client����ִ��get����
        HttpClient client = new DefaultHttpClient();
        //respons��ִ��get������������
        HttpResponse response = client.execute(get);
        //ת��respon���Ϊutf-8��ʽ
        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        ������ʽ��
        System.out.println(result);
    }
}
