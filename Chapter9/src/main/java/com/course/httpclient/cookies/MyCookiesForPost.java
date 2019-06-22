package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    //用来存储Cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        ///从配置文件中拼接测试URL
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;
        //测试逻辑代码
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        ///获取Cookies信息
        this.store = ((DefaultHttpClient) client).getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies name=" + name + ";cookie value=" + value);
        }
    }

        @Test(dependsOnMethods = {"testGetCookies"})
        public void testPostMethod () throws IOException{
            String uri = bundle.getString("test.post.with.cookies");
            //拼接最终的测试地址
            String testurl = this.url + uri;
            //声明一个client对象，用来进行方法的执行
            DefaultHttpClient client = new DefaultHttpClient();
            //声明一个方法，这个方法就是post方法
            HttpPost post = new HttpPost(testurl);
            //添加参数
            JSONObject param = new JSONObject();
            param.put("name", "wangjiaxin");
            param.put("age", "18");
            //设置请求头信息,设置Header
            post.setHeader("content-type", "application/json");
            //将参数信息添加到方法中
            StringEntity entity = new StringEntity(param.toString(), "utf-8");
            post.setEntity(entity);
            //声明一个对象来进行相应结果的存储
            String result;
            //设置Cookies信息
            client.setCookieStore(this.store);
            //执行Post方法
            HttpResponse response = client.execute(post);
            // 获取相应结果
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
            //处理结果，判断返回结果是否符合预期
            //将返回的响应结果字符串转化为json对象
            JSONObject resultJson = new JSONObject(result);
            //获取到结果值
            String success = (String) resultJson.get("wangjiaxin");
            String status = (String) resultJson.get("status");
            //具体判断结果值
            Assert.assertEquals("success", success);
            Assert.assertEquals("1", status);
        }
    }

