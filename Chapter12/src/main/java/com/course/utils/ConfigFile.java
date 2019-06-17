package com.course.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle bundle= ResourceBundle.getBundle("application", Locale.CHINA);;

    public static String getUrl(com.course.model.InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        String testUrl;
        if(name == com.course.model.InterfaceName.GETUSERLIST){
            uri = bundle.getString("getUserList.uri");

        }

        if(name == com.course.model.InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }

        if(name == com.course.model.InterfaceName.UPDATEUSERINFO){
            uri = bundle.getString("updateUserInfo.uri");
        }

        if(name == com.course.model.InterfaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }

        if(name == com.course.model.InterfaceName.ADDUSERINFO){
            uri = bundle.getString("addUser.uri");
        }
        testUrl = address + uri;
        return testUrl;
    }
}
