package com.ab.testcase;

import com.ab.utiles.ConfigFile;
import com.ab.utiles.HttpsUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
    @Test
    public void test() throws Exception {
        String result = "";
//            调用工具类中的getHttpClient静态方法，创建httpClient对象实例
        CloseableHttpClient httpClient = HttpsUtils.getHttpClient();
//            调用httppost方法，创建httppost对象实例，并通过工具类ConfigFile中的getUrl方法赋值
        HttpPost httpPost = new HttpPost(ConfigFile.getUrl("bst","getTodoMenuListByNeedGrade"));
                // 设置头信息，创建header字典存储键值对

                Map<String, String> header = new HashMap<>();
                header.put("content-type", "application/x-www-form-urlencoded");
//                通过header对象调用entrySet方法？？？？
//                header.entrySet();


                // 设置请求参数，存储发起请求列表
               Map<String,String> param = new HashMap<>();
               param.put("token","00a3e23bf2a74993a13d586e99950d39");
               param.put("menuType","todu");
               param.put("title","测试");

//                通过httpClient对象调用excute方法，参数为httpPost，定义httpResponse存储返回值
                HttpResponse httpResponse = httpClient.execute(httpPost);
//                定义statusCode存储响应报文中的响应编码
                int statusCode = httpResponse.getStatusLine().getStatusCode();
//                判断响应编码为200，打印结果，存储并打印Cookies信息
                if (statusCode == HttpStatus.SC_OK) {
                    HttpEntity resEntity = httpResponse.getEntity();
                    result = EntityUtils.toString(resEntity);
                    System.out.println(result);
                    CookieStore cookieStore = new BasicCookieStore();
                    System.out.println(cookieStore.getCookies());
        }
    }
}