package com.ab.utiles;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;

public class GetDataProviderCsv {
    @DataProvider()
//    ��ȡ������Ϊ����
    public static Object[][] getDataProvider(Method method) throws IOException {
        File directory=new File(".");
        String path=".src.main.resources.testdata.";
//        ��ȡ������ƴ��csv�ļ�
        String filename=method.getName()+".csv";
        String absolutePath=directory.getCanonicalPath()+path.replaceAll("\\.", Matcher.quoteReplacement("\\"))+filename;
//        return  new ReadCsv(absolutePath);
        Object[][] objects = ReadCsv.getSearchData(absolutePath);
        return objects;
    }

}
