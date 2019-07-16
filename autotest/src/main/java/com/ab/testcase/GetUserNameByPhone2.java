package com.ab.testcase;

import com.ab.model.Getusernamebyphone;
import com.ab.utiles.ConfigFile;
import com.ab.utiles.GetDataProvider;
import com.ab.utiles.HttpsUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by AB056967 on 2019/5/10 0010.
 */
public class GetUserNameByPhone2 {

    @Test(dataProvider="getDataProvider",dataProviderClass = GetDataProvider.class)
    public void Getusernamebyphone(Getusernamebyphone getusernamebyphone) throws Exception {

         //调用工具类发起get请求
        String result = HttpsUtils.get(ConfigFile.getUrl("im", "getUserNameByPhone2")+getusernamebyphone.getPhone());
//      数据库中获取expect
        String expect = getusernamebyphone.getExpect();
        Assert.assertEquals(expect,result);

    }



}
