package online.liaojy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liaojy
 * @date 2023/11/7 - 20:54
 */
@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String testHello(){
        System.out.println("TestController-->testHello()");
        System.out.println(1/0);
        return "success";
    }

}
