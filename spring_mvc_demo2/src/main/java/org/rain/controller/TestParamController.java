package org.rain.controller;

import org.rain.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liaojy
 * @date 2023/10/9 - 8:32
 */
@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username："+username);
        System.out.println("password："+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "name",required = true,defaultValue = "everyone") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue(value = "JSESSIONID",required = false) String jsessionId
    ) {
        System.out.println("username："+username);
        System.out.println("password："+password);
        System.out.println("referer："+referer);
        System.out.println("jsessionId："+jsessionId);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }

}
