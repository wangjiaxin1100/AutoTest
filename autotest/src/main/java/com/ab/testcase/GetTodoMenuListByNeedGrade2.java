package com.ab.testcase;

import com.ab.model.Gettodomenulistbyneedgrade;
import com.ab.utiles.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.http.entity.StringEntity;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetTodoMenuListByNeedGrade2 {
    @Test(dataProvider="getDataProvider",dataProviderClass = GetDataProvider.class)
    public void Gettodomenulistbyneedgrade(Gettodomenulistbyneedgrade gettodomenulistbyneedgrade) throws Exception {
        Map<String,String> param = new HashMap<>();
        param.put("token",gettodomenulistbyneedgrade.getToken());
        param.put("menuType",gettodomenulistbyneedgrade.getMenutype());
        param.put("title",gettodomenulistbyneedgrade.getTitle());

        String result = HttpsUtils.post(ConfigFile.getUrl("bst","getTodoMenuListByNeedGrade"),param);
        JSONObject res1 = JSON.parseObject(result, Feature.OrderedField);//解析时不调整顺序
        String RESULT_CODE = res1.getString("RESULT_CODE");
        String expect = gettodomenulistbyneedgrade.getExpect();
        System.out.println(result);
        Assert.assertEquals(expect,RESULT_CODE);


    }
}