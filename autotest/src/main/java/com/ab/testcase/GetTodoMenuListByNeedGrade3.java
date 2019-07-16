package com.ab.testcase;

import com.ab.utiles.ConfigFile;
import com.ab.utiles.GetDataProviderCsv;
import com.ab.utiles.HttpsUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetTodoMenuListByNeedGrade3 {
//    从csv文件中读取发起报文
//    CSV文件中的return objects返回值
    @Test(dataProvider = "getDataProvider", dataProviderClass = GetDataProviderCsv.class)
    public void Gettodomenulistbyneedgrade(Map<String,String> data) throws Exception {
//        将读取的文件转换为JSON格式
        Map<String,String> param = new HashMap<>();
        param.put("token",data.get("token"));
        param.put("menuType",data.get("menuType"));
        param.put("title",data.get("title"));

        String result = HttpsUtils.post(ConfigFile.getUrl("bst","getTodoMenuListByNeedGrade"),param);

        System.out.println(result);
    }
}
