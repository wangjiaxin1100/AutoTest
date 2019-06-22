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
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetusernamebyphoneMapper getusernamebyphoneMapper = sqlSession.getMapper(GetusernamebyphoneMapper.class);
        Getusernamebyphone getusernamebyphone = getusernamebyphoneMapper.selectByPrimaryKey(1);
        System.out.println("�ӿڷ�ʽ"+getusernamebyphone.getPhone());


        Getusernamebyphone getusernamebyphone1=sqlSession.selectOne("selectByPrimaryKey",1);
        System.out.println("select��ʽ"+getusernamebyphone1.getPhone());


        BaseMapper baseMapper = sqlSession.getMapper(BaseMapper.class);
        List<LinkedHashMap<String,Object>> list = baseMapper.select("select * from getusernamebyphone");
        System.out.println("ȫsql�ķ�ʽ"+list.get(0).get("phone"));
    }
}
