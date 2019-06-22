package com.ab.testcase;

import com.ab.utiles.ConfigFile;
import com.ab.utiles.HttpsUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class GetTodoMenuListByNeedGrade {

    @Test
    public void Gettodomenulistbyneedgrade() throws Exception {
        String result;
        Map<String, String> param=new HashMap<String,String>();
        param.put("token","00a3e23bf2a74993a13d586e99950d39");
        param.put("menuType","todu");

        StringEntity entity = new StringEntity(param.toString(),"utf-8");


        result = HttpsUtils.post(ConfigFile.getUrl("bst","getTodoMenuListByNeedGrade"),param);

        JSONObject res1 = JSON.parseObject(result, Feature.OrderedField);//解析时不调整顺序
        String RESULT_CODE = res1.getString("RESULT_CODE");
        String expect = "M00000";
        System.out.println(param.toString());
        System.out.println("实际结果+++++++"+result);
        Assert.assertEquals(expect,RESULT_CODE);

    }
}