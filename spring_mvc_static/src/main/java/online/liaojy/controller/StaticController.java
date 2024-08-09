package online.liaojy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liaojy
 * @date 2023/10/25 - 12:32
 */
@Controller
public class StaticController {

    @RequestMapping("/static/page")
    public String toStaticPage(){
        return "forward:/WEB-INF/templates/success.html";
    }

}
