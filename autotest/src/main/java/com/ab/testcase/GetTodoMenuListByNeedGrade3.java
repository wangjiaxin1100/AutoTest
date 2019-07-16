package com.ab.testcase;

import com.ab.utiles.ConfigFile;
import com.ab.utiles.GetDataProviderCsv;
import com.ab.utiles.HttpsUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetTodoMenuListByNeedGrade3 {
//    ��csv�ļ��ж�ȡ������
//    CSV�ļ��е�return objects����ֵ
    @Test(dataProvider = "getDataProvider", dataProviderClass = GetDataProviderCsv.class)
    public void Gettodomenulistbyneedgrade(Map<String,String> data) throws Exception {
//        ����ȡ���ļ�ת��ΪJSON��ʽ
        Map<String,String> param = new HashMap<>();
        param.put("token",data.get("token"));
        param.put("menuType",data.get("menuType"));
        param.put("title",data.get("title"));

        String result = HttpsUtils.post(ConfigFile.getUrl("bst","getTodoMenuListByNeedGrade"),param);

        System.out.println(result);
    }
}
