package com.ab.testcase;

import com.ab.dao.BaseMapper;
import com.ab.dao.GetusernamebyphoneMapper;
import com.ab.model.Getusernamebyphone;
import com.ab.utiles.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class MybatisTest {

    @Test
    public void mybatisTest() throws IOException {
//        通过使用DatebaseUtil工具类中的getsqlsession方法连接数据库
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
//      dao接口方式获取对象属性
        GetusernamebyphoneMapper getusernamebyphoneMapper = sqlSession.getMapper(GetusernamebyphoneMapper.class);
        Getusernamebyphone getusernamebyphone = getusernamebyphoneMapper.selectByPrimaryKey(1);
        System.out.println("接口方式"+getusernamebyphone.getPhone());

//      sql方式获取对象属性
        Getusernamebyphone getusernamebyphone1=sqlSession.selectOne("selectByPrimaryKey",1);
        System.out.println("select方式"+getusernamebyphone1.getPhone());

//      直接通过sql查询方式获取数据库对象属性
        BaseMapper baseMapper = sqlSession.getMapper(BaseMapper.class);
//       String类型中的字典获取对象属性
        List<LinkedHashMap<String,Object>> list = baseMapper.select("select * from getusernamebyphone");
        System.out.println("全sql的方式"+list.get(0).get("phone"));
    }
}
