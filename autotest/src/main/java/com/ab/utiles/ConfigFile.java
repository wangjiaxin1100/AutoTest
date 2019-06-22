package com.ab.utiles;

import java.util.ResourceBundle;

/**
 * Created by AB056967 on 2019/5/10 0010.
 */
public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("applicattion");
    public static String getUrl(String a,String b){
        String x = bundle.getString(a);
        String y = bundle.getString(b);
        String url = x+y;

        return url;
    }
}
