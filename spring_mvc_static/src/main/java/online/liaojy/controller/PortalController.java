package online.liaojy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liaojy
 * @date 2023/10/24 - 20:15
 */
@Controller
public class PortalController {
    @RequestMapping("/")
    public String portal(){
        return "index";
    }
}
