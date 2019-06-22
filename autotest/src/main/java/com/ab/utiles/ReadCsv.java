package com.ab.utiles;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCsv {
    public static Object[][] getSearchData(String FileName) throws IOException {
        Object[][] objects =null;
        CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(new FileInputStream(new File(FileName)), "GBK"))).build();
        List<String[]> list = csvReader.readAll();
        //取列名
        String clumname[]=list.get(0);

        String aa[] = null;
        objects = new Object[list.size()][];


        for (int i=1;i<list.size();i++) {
            Map<String,String> map =new HashMap<>();
            int y=i-1;
            aa=list.get(i);
            for (int x=0;x<aa.length;x++) {
            map.put(clumname[x],aa[x]);
            }
            objects[y] = new Object[]{map};
        }

        return objects;
    }
}