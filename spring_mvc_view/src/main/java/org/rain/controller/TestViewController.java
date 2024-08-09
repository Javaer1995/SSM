package org.rain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liaojy
 * @date 2023/10/15 - 17:47
 */
@Controller
public class TestViewController {

    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){
        //return "forward:/test/view/thymeleaf";
        return "forward:/WEB-INF/templates/success.html";
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){
        return "redirect:/test/view/thymeleaf";
    }

}
