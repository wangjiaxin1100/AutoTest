package com.ab.testcase;

import com.ab.utiles.ConfigFile;
import com.ab.utiles.GetDataProviderCsv;
import com.ab.utiles.HttpsUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class GetUserNameByPhone3 {
//    通过访问CSV文件读取测试输入数据

    @Test(dataProvider = "getDataProvider", dataProviderClass = GetDataProviderCsv.class)
    public void Getusernamebyphone(Map<String, String> data) throws Exception {

        String result = HttpsUtils.get(ConfigFile.getUrl("im", "getUserNameByPhone2")+data.get("phone"));
//        testdata下的Getusernamebyphone.csv文件

        Assert.assertEquals(result,data.get("expect"));
    }
}
