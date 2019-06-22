package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
//    创建url对象
    private String url;
    private ResourceBundle bundle;
    //用来存储Cookies信息的变量
    private CookieStore store;
//    测试方法执行前加载url
    @BeforeTest
    public void beforeTest(){
//        对应识别properties文件，Local对象设置字符编码
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        //读取配置文件中的url
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        ///从配置文件中拼接测试URL
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;
        //测试逻辑代码
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        ///获取Cookies信息
        this.store = client.getCookieStore();
//        返回Cookie列表
        List<Cookie> cookieList =store.getCookies();
        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value= cookie.getValue();
//            获取所有key和value
            System.out.println("cookies name=" + name + ";cookie value="+value);
        }

    }
//    信息抽取，将获取的Cookies带上访问下一个请求
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException{
//        访问地址拼接，取application.properties中的uri
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;
//        传递get方法参数
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置Cookies信息，store中存储的Cookies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);

        //获取响应状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = "+ StatusCode);

        if (StatusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }

    }

}