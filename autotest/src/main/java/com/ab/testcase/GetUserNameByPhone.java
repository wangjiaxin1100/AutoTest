package com.ab.testcase;

import com.ab.utiles.ConfigFile;
import com.ab.utiles.HttpsUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by AB056967 on 2019/5/10 0010.
 */
public class GetUserNameByPhone {

    @Test
    public void getUserNameByPhoneTest() throws Exception {
        String result;
//        httpclient 4.5.2版本写法
//        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet get = new HttpGet(ConfigFile.getUrl("im","getUserNameByPhone"));
//      调用本地工具类，绕过https校验
        CloseableHttpClient client1 = HttpsUtils.getHttpClient();
        HttpResponse response = client1.execute(get);
        result= EntityUtils.toString(response.getEntity());
        System.out.println("实际结果+++++++"+result);
//        System.out.println(getphone.toString());

        JSONObject res1 = JSON.parseObject(result, Feature.OrderedField);//解析时不调整顺序
        String data = res1.getString("data");
        String expect1 = "{\"accountType\":2,\"phoneNumber\":\"+8613699282826\",\"status\":\"1\",\"username\":\"245800\"}";
        String expect = "{\"data\":{\"accountType\":2,\"phoneNumber\":\"+8613699282826\",\"status\":\"1\",\"username\":\"245800\"},\"retcde\":\"0\",\"retmsg\":\"成功\"}";

        Assert.assertEquals(data,expect1);
        Assert.assertEquals(expect,result);
    }


}
