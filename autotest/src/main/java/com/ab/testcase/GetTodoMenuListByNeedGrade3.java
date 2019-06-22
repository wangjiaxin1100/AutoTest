package com.ab.testcase;

import com.ab.utiles.ConfigFile;
import com.ab.utiles.GetDataProviderCsv;
import com.ab.utiles.HttpsUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetTodoMenuListByNeedGrade3 {

    @Test(dataProvider = "getDataProvider", dataProviderClass = GetDataProviderCsv.class)
    public void Gettodomenulistbyneedgrade(Map<String,String> data) throws Exception {
        Map<String,String> param = new HashMap<>();
        param.put("token",data.get("token"));
        param.put("menuType",data.get("menuType"));
        param.put("title",data.get("title"));

        String result = HttpsUtils.post(ConfigFile.getUrl("bst","getTodoMenuListByNeedGrade"),param);

        System.out.println(result);
    }
}
