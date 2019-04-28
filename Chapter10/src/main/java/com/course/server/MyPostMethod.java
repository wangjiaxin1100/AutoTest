package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是我全部的Post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    private static Cookie cookie;

    //用户登录成功获取Cookies再访问其他接口获取到列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取Cookie信息", httpMethod = "POST")

    public String login(HttpServletResponse response,
                        @RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password) {
        if (username.equals("zhangsan") && password.equals("123456")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功了";
        }
        return "用户名或密码错误";

    }
    @RequestMapping(value = "getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){

        User user;
        //获取Cookies
        Cookie [] cookies = request.getCookies();
        //验证Cookies是否合法
        for (Cookie c : cookies){
            if(c.getName().equals("login")
                    &&c.getValue().equals("true")
                    &&u.getUserName().equals("zhangsan")
                    &&u.getPassword().equals("123456")
                    ) {
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";


    }
}


