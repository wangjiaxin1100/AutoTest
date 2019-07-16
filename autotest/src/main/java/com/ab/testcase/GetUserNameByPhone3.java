package com.ab.testcase;

import com.ab.utiles.ConfigFile;
import com.ab.utiles.GetDataProviderCsv;
import com.ab.utiles.HttpsUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class GetUserNameByPhone3 {
//    ͨ������CSV�ļ���ȡ������������

    @Test(dataProvider = "getDataProvider", dataProviderClass = GetDataProviderCsv.class)
    public void Getusernamebyphone(Map<String, String> data) throws Exception {

        String result = HttpsUtils.get(ConfigFile.getUrl("im", "getUserNameByPhone2")+data.get("phone"));
//        testdata�µ�Getusernamebyphone.csv�ļ�

        Assert.assertEquals(result,data.get("expect"));
    }
}
