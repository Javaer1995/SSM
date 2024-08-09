package org.rain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liaojy
 * @date 2023/9/8 - 0:36
 */
@Controller
public class HelloController {

    // @RequestMapping处理匹配路径的请求
    // 服务器中的/路径表示：http://localhost:8080/上下文/，本例为http://localhost:8080/spring_mvc_helloworld/
    @RequestMapping("/")
    public String portal(){
        // 返回首页的逻辑视图，视图解析器会根据定义好的前缀和后缀匹配对应的资源，经过thymeleaf的渲染后页面
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success555";
    }

}
