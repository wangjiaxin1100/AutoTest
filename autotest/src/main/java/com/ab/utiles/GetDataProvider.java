package com.ab.utiles;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetDataProvider {
    @DataProvider()
    public static Object[][] getDataProvider(Method method) throws IOException {

        System.out.println("@DataProvider(name='getDataProvider')");
        System.out.println("dataProvider="+method.getName());

        Object[][] obj;
        SqlSession session = DatabaseUtil.getSqlSession();
        List<Map<String,Object>> list = new ArrayList<>();
        list = session.selectList(method.getName());
        System.out.println(method.getName());
//      判断数据库中的用例条数
        if (list.size() > 1) {
            obj = new Object[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                obj[i] = new Object[]{list.get(i)};
        }
            return obj;
        }else{
            System.out.println("用例为空");
            return null;
        }
    }

    public static String getComment(){
return null;
    }

}
