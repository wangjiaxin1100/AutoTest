package com.ab.testcase;

import com.ab.utiles.ConfigFile;
import com.ab.utiles.HttpsUtils;
import com.ab.utiles.ReadCsv;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.collections.MapUtils;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ab.utiles.HttpsUtils.getHttpClient;

public class MyTest {
    @Test
    public void test() throws Exception {
            String result = "";
            CloseableHttpClient httpClient = HttpsUtils.getHttpClient();
                HttpPost httpPost = new HttpPost(ConfigFile.getUrl("bst","getTodoMenuListByNeedGrade"));
                // 设置头信息

                Map<String, String> header = new HashMap<String, String>();
                header.put("content-type", "application/x-www-form-urlencoded");
                header.entrySet();

                // 设置请求参数
               Map<String,String> param = new HashMap<>();
               param.put("token","00a3e23bf2a74993a13d586e99950d39");
               param.put("menuType","todu");
               param.put("title","测试");

                HttpResponse httpResponse = httpClient.execute(httpPost);
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode == HttpStatus.SC_OK) {
                    HttpEntity resEntity = httpResponse.getEntity();
                    result = EntityUtils.toString(resEntity);
                    System.out.println(result);
                    CookieStore cookieStore = new BasicCookieStore();
                    System.out.println(cookieStore.getCookies());
        }
    }
}