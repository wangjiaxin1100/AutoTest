package com.ab.testcase;

import com.ab.model.Gettodomenulistbyneedgrade;
import com.ab.utiles.ConfigFile;
import com.ab.utiles.GetDataProvider;
import com.ab.utiles.HttpsUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetTodoMenuListByNeedGrade2 {
    @Test(dataProvider="getDataProvider",dataProviderClass = GetDataProvider.class)
    public void Gettodomenulistbyneedgrade(Gettodomenulistbyneedgrade gettodomenulistbyneedgrade) throws Exception {
        Map<String,String> param = new HashMap<>();
//        读取数据库中的值
        param.put("token",gettodomenulistbyneedgrade.getToken());
        param.put("menuType",gettodomenulistbyneedgrade.getMenutype());
        param.put("title",gettodomenulistbyneedgrade.getTitle());
//        变量result存储post方法返回值
        String result = HttpsUtils.post(ConfigFile.getUrl("bst","getTodoMenuListByNeedGrade"),param);
//        将json字符串转换为JSONObject并保持顺序
        JSONObject res1 = JSON.parseObject(result, Feature.OrderedField);//解析时不调整顺序
        String RESULT_CODE = res1.getString("RESULT_CODE");
        String expect = gettodomenulistbyneedgrade.getExpect();
        System.out.println(result);
        Assert.assertEquals(expect,RESULT_CODE);


    }
}