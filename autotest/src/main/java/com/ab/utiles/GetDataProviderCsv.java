package com.ab.utiles;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class GetDataProviderCsv {
    @DataProvider()
    public static Object[][] getDataProvider(Method method) throws IOException {
        File directory=new File(".");
        String path=".src.main.resources.testdata.";
        String filename=method.getName()+".csv";
        String absolutePath=directory.getCanonicalPath()+path.replaceAll("\\.", Matcher.quoteReplacement("\\"))+filename;
//        return  new ReadCsv(absolutePath);
        Object[][] objects = ReadCsv.getSearchData(absolutePath);
        return objects;
    }

}
