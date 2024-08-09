package online.liaojy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liaojy
 * @date 2023/11/13 - 19:48
 */
@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String testHello(){
        // 在控制器方法中，制造一个数值运算异常
        System.out.println(1/0);
        return "success";
    }

}
