package org.rain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liaojy
 * @date 2023/10/9 - 8:49
 */
@Controller
public class PortalController {
    @RequestMapping("/")
    public String portal(){
        return "index";
    }
}